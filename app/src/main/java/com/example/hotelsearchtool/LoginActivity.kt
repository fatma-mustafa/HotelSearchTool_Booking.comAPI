package com.example.hotelsearchtool

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class LoginActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    var user_state:String?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val signupBTN = findViewById<TextView>(R.id.signup)
        signupBTN.setOnClickListener { startActivity(Intent(this, Registration::class.java)) }
        user_state=intent.getStringExtra("State")
        auth = Firebase.auth
        if(auth.currentUser !=null && user_state!="new_user")
        {
            startActivity(Intent(this,MainActivity::class.java))
        }

        val signinbtn = findViewById<Button>(R.id.signin)
        signinbtn.setOnClickListener {
            loginUser()
        }
    }
//
//    override fun onStart() {
//        super.onStart()
//        if(auth.currentUser !=null && user_state!="new_user")
//        {
//            startActivity(Intent(this,MainActivity::class.java))
//        }
//    }


    private fun loginUser() {

        val emailp: EditText = findViewById(R.id.editTextTextEmailAddress)
        val passwordp: EditText = findViewById(R.id.editTextTextPassword)
        val email=emailp.text.toString().trim()
        val password=passwordp.text.toString().trim()
        var valid =0

        if (email.isEmpty()) {
            emailp.error = "E-mail is required!"
            emailp.requestFocus()
        }else valid++
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailp.error = "Please, provide valid e-mail"
            emailp.requestFocus()
        }else valid++
        if (password.isEmpty()) {
            passwordp.error = "Password is required!"
            passwordp.requestFocus()
        }else valid++
        if(password.length<6)
        {
            passwordp.error = "Password should be more than 6 characters"
            passwordp.requestFocus()
        }else valid++


    if(valid == 4) {auth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
        if(it.isSuccessful)
        {
            startActivity(Intent(this, MainActivity::class.java))
        }
        else
        {
            Toast.makeText(this,"Login failed check your email and password",Toast.LENGTH_LONG).show()
        }
    }

    }}


}
