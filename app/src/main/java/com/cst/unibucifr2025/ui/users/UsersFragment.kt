package com.cst.unibucifr2025.ui.users

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cst.unibucifr2025.R
import com.cst.unibucifr2025.adapters.UsersAdapter
import com.cst.unibucifr2025.data.repositories.UserIdentityCardRepository
import com.cst.unibucifr2025.models.UserModel
import com.cst.unibucifr2025.models.one_to_one.UserIdentityCardModel
import com.cst.unibucifr2025.networking.repository.UserRepository
import com.cst.unibucifr2025.utils.extensions.showToast
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException
import java.util.UUID
import com.cst.unibucifr2025.data.repositories.UserRepository as UserDataRepository

class UsersFragment : Fragment() {

    private val adapter = UsersAdapter { user ->
        getUserWidIdentityCard(user)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_users, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<RecyclerView>(R.id.rv_users).apply {
            this.adapter = this@UsersFragment.adapter
            this.layoutManager = LinearLayoutManager(this.context)
        }

        getUsersFromDatabase()
        getUsersFromServer()
    }

    private fun getUserWidIdentityCard(model: UserModel) {
        viewLifecycleOwner.lifecycleScope.launch {
            val userWithID = withContext(Dispatchers.IO) {
                UserDataRepository.getUserWithIDC(model.id)
            } ?: return@launch

            Snackbar.make(
                view ?: return@launch,
                "${userWithID.user.firstName} ${userWithID.user.lastName}, cnp: ${userWithID.id.cnp}",
                Snackbar.LENGTH_SHORT
            ).show()
        }
    }

    private fun getUsersFromDatabase() {
        viewLifecycleOwner.lifecycleScope.launch {
            val result = withContext(Dispatchers.IO) {
                UserDataRepository.getAllUsers()
            }

            if (result.size > 4) {
                val users = listOf(result[0], result[2], result[4])
                adapter.submitList(users)
            }

//            users.clear()
//            if(result.size > 2) {
//                users.addAll(result.subList(0, 2))
//            }
//            adapter.notifyItemChanged(0, users.size)
        }
    }

    private fun getUsersFromServer() {
        viewLifecycleOwner.lifecycleScope.launch {
            try {
                val result = withContext(Dispatchers.IO) {
                    UserRepository.getUsers(1)
                }

                withContext(Dispatchers.IO) {
                    delay(3000)

                    val users = result.data
                    UserDataRepository.insert(users)

                    val idCards = users.map { user ->
                        UserIdentityCardModel(
                            cnp = UUID.randomUUID().toString(),
                            userOwnerId = user.id
                        )
                    }
                    UserIdentityCardRepository.insert(idCards)
                }

                adapter.submitList(result.data)

//                users.clear()
//                users.addAll(result.data)
//                adapter.notifyItemChanged(0, users.size)
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