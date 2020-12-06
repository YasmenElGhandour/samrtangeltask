package com.yasmen.smartangle.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.yasmen.smartangle.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
    }
    fun Task1(view : View){
        startActivity(Intent(this@MainActivity,ProfileActivity::class.java))
    }

    fun Task2(view : View){
        startActivity(Intent(this@MainActivity,SignUpActivity::class.java))
    }
}