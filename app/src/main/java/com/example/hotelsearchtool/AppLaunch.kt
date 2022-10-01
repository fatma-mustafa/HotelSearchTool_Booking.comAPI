package com.example.hotelsearchtool

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.lifecycle.lifecycleScope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class AppLaunch : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app_launch)
        Handler().postDelayed({
            auth = Firebase.auth
            if(auth.currentUser !=null) {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
            else
            {
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            }
        }, 2000)

    }


}