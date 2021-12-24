package com.hadi.loginregister

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    lateinit var btnLogin: LinearLayout
    lateinit var btnRegister: TextView
    lateinit var Email: EditText
    lateinit var Password: EditText
    lateinit var ErrorEmail: TextInputLayout
    lateinit var ErrorPassword: TextInputLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnLogin = findViewById(R.id.btnLogin)
        btnRegister = findViewById(R.id.register)
        Email = findViewById(R.id.email)
        Password = findViewById(R.id.password)
        ErrorEmail = findViewById(R.id.emailError)
        ErrorPassword = findViewById(R.id.passError)


        btnLogin.setOnClickListener() {

            if (Email.text.toString().isEmpty() && Password.text.toString().isEmpty()){
                Toast.makeText(this, "Email Dan Password Diperlukan", Toast.LENGTH_SHORT).show()
            }else if (Email.text.toString().isEmpty()) {
                ErrorEmail.error = "Email Diperlukan!"
            } else if (!Patterns.EMAIL_ADDRESS.matcher(Email.text.toString()).matches()) {
                ErrorEmail.error = "Email Tidak Valid!"
            } else if (Password.text.toString().isEmpty()) {
                ErrorPassword.error = "Password Diperlukan!"
            } else if (Password.text.toString().length <= 5 ) {
                ErrorPassword.error = "Password Harus Lebih Dari 6 Karakter!"
            } else if(Email.text.toString() == Passing.username && Password.text.toString() == Passing.password){
                startActivity(Intent(this, DasboardActivity::class.java))
            } else {
                Toast.makeText(this, "Email Atau Password Anda Salah!", Toast.LENGTH_SHORT).show()
            }


        }

        btnRegister.setOnClickListener(){
            startActivity(Intent(this, RegisterActivity::class.java))
        }

    }
}