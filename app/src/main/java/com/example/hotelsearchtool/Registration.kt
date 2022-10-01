package com.example.hotelsearchtool

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class Registration : AppCompatActivity() {
    lateinit var auth:FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        auth = Firebase.auth
        val signin = findViewById<TextView>(R.id.signin)
        val signupBTN = findViewById<Button>(R.id.signupBTN)

        signin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

        signupBTN.setOnClickListener {
            SignUpUser()
        }

    }

    fun SignUpUser() {
        val namep = findViewById<EditText>(R.id.name)
        val emailp = findViewById<EditText>(R.id.email)
        val passwordp = findViewById<EditText>(R.id.password)
        val confirmpassp = findViewById<EditText>(R.id.confirmpass)


        var valid=0
        val email=emailp.text.toString().trim()
        val password=passwordp.text.toString().trim()

        if (namep.text.toString().trim().isEmpty()) {
            namep.error = "Your name is required!"
            namep.requestFocus()
        }//else valid++
        if (email.isEmpty()) {
            emailp.error = "E-mail is required!"
            emailp.requestFocus()
        }else valid++
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailp.error = "Please, provide valid e-mail !"
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
        if (confirmpassp.text.toString().trim()!=password) {
            confirmpassp.error = "Passwords don't match"
            confirmpassp.requestFocus()
        }else valid++
       if(valid==5){ auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener {
        if(it.isSuccessful)
            {
                Toast.makeText(this,"you have signed up successfully",Toast.LENGTH_SHORT).show()
                startActivity(Intent(this,LoginActivity::class.java).putExtra("State","new_user"))
            }
            else{
                Toast.makeText(this,"your sign up failed",Toast.LENGTH_SHORT).show()

            }
        }
    }}

}