package com.cst.unibucifr2025

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.cst.unibucifr2025.models.AddressKotlin
import com.cst.unibucifr2025.models.Direction
import com.cst.unibucifr2025.models.DirectionType
import com.cst.unibucifr2025.models.East
import com.cst.unibucifr2025.models.North
import com.cst.unibucifr2025.models.South
import com.cst.unibucifr2025.models.West
import com.cst.unibucifr2025.utils.extensions.logErrorMessage

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        findViewById<Button>(R.id.btn_click_me).setOnClickListener {
            goToSecondActivity()
            //changeDirection()

            Log.e("TAG", "setOnClickListener")
        }

        val directions = ArrayList<Direction>()

        val directionN = North(0)
        val directionS = South(0)
        val directionW = East(0)
        val directionE = West(0)

        directions.add(directionN)
        directions.add(directionS)
        directions.add(directionW)
        directions.add(directionE)
    }

    override fun onStart() {
        super.onStart()

        Log.e("TAG", "onStart")
    }

    override fun onResume() {
        super.onResume()

        Log.e("TAG", "onResume")
    }

    override fun onPause() {
        super.onPause()

        Log.e("TAG", "onPause")
    }

    override fun onStop() {
        super.onStop()

        Log.e("TAG", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.e("TAG", "onDestroy")
    }

    private fun changeDirection() {
        findViewById<TextView>(R.id.textView).text = getString(DirectionType.entries.random().resourceId)
    }

    private fun goToSecondActivity() {
        val intent = Intent(this, ControllerActivity::class.java)
        startActivity(intent)
        finish()
    }
}