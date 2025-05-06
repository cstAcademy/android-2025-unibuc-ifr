package com.cst.unibucifr2025.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.cst.unibucifr2025.BuildConfig
import com.cst.unibucifr2025.R
import com.cst.unibucifr2025.networking.repository.AuthenticationRepository
import com.cst.unibucifr2025.utils.extensions.logErrorMessage
import com.cst.unibucifr2025.utils.extensions.showToast
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_login, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (view.findViewById(R.id.tv_register) as? TextView)?.setOnClickListener {
            val email = view.findViewById<EditText>(R.id.edt_email).text.toString()
            goToRegister(email)
        }

        (view.findViewById(R.id.btn_login) as? Button)?.setOnClickListener {
            doLogin()
        }

        if(BuildConfig.DEBUG) {
            view.findViewById<EditText>(R.id.edt_email).setText("eve.holt@reqres.in")
            view.findViewById<EditText>(R.id.edt_password).setText("cityslicka")
        }
    }

    private fun goToRegister(email: String) {
        val action = LoginFragmentDirections.actionLoginFragmentToRegisterFragment(email)
        findNavController().navigate(action)
    }

    private fun goToHome() {
        val action = LoginFragmentDirections.actionLoginFragmentToHomeFragment()
        findNavController().navigate(action)
    }

    private fun doLogin() {
        val email = view?.findViewById<EditText>(R.id.edt_email)?.text?.toString()
        val password = view?.findViewById<EditText>(R.id.edt_password)?.text?.toString()

        if (email.isNullOrEmpty() || password.isNullOrEmpty()) {
            "Invalid credentials".showToast(requireContext())
            return
        }

        viewLifecycleOwner.lifecycleScope.launch {
            try {
                val result = withContext(Dispatchers.IO) {
                    AuthenticationRepository.login(email, password)
                }

                "Login success: ${result.token}".showToast(requireContext())

                goToHome()
            } catch (e: IOException) {
                ("Please check your internet connection").showToast(requireContext())
            } catch (e: HttpException) {
                ("Server error: ${e.code()}").showToast(requireContext())
            } catch (e: Exception) {
                ("Unexpected error: ${e.localizedMessage}").showToast(requireContext())
            }
        }
    }
}