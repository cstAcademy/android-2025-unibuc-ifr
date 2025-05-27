package com.cst.unibucifr2025

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.NavHostFragment
import com.cst.unibucifr2025.managers.SharedPrefsManager
import com.cst.unibucifr2025.managers.isUserLoggedIn
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ControllerActivity : AppCompatActivity() {

    private var isAppInitialized = false

    private val navController by lazy {
        val host = supportFragmentManager
            .findFragmentById(R.id.fcv_main)
                as? NavHostFragment
            ?: error("NavHostFragment not found in layout")
        host.navController
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setupSplashScreen()

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_controller)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        tryToAuthUser()
    }

    private fun setupSplashScreen() {
        val splashScreen = installSplashScreen()
        splashScreen.setKeepOnScreenCondition {
            !isAppInitialized
        }
        splashScreen.setOnExitAnimationListener {
            it.remove()
        }
    }

    private fun tryToAuthUser() {
        lifecycleScope.launch {
            delay(3000)

            when (SharedPrefsManager.isUserLoggedIn()) {
                true -> initHome()
                false -> initAuthentication()
            }

            isAppInitialized = true
        }
    }

    private fun initAuthentication() {
        navController.setGraph(R.navigation.navigation_authentication)
    }

    private fun initHome() {
        navController.setGraph(R.navigation.navigation_home)
    }
}