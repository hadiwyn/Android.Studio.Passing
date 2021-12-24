package com.hadi.loginregister

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import com.google.android.material.textfield.TextInputLayout

class RegisterActivity : AppCompatActivity() {

    lateinit var btnRegister: LinearLayout
    lateinit var email: EditText
    lateinit var password: EditText
    lateinit var konfPassword: EditText
    lateinit var emailError: TextInputLayout
    lateinit var passwordError: TextInputLayout
    lateinit var konfPasswordError: TextInputLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btnRegister = findViewById(R.id.btnRegister)
        email = findViewById(R.id.email)
        password = findViewById(R.id.password)
        konfPassword = findViewById(R.id.Konfpassword)
        emailError = findViewById(R.id.emailError)
        passwordError = findViewById(R.id.passError)
        konfPasswordError = findViewById(R.id.KonfpassError)

        btnRegister.setOnClickListener() {

            if (email.text.toString().isEmpty() && password.text.toString().isEmpty()) {
                Toast.makeText(this, "Email Dan Password Diperlukan!", Toast.LENGTH_SHORT).show()
            } else if (email.text.toString().isEmpty()) {
                emailError.error = "Email Diperlukan!"
            } else if (!Patterns.EMAIL_ADDRESS.matcher(email.text.toString()).matches()) {
                emailError.error = "Email Tidak Valid!"
            } else if (password.text.toString().isEmpty()) {
                passwordError.error = "Password Diperlukan!"
            } else if (password.length() <= 6) {
                passwordError.error = "Password Harus Lebih Dari 6 Karakter!"
            } else if (konfPassword.text.toString().isEmpty()) {
                konfPasswordError.error = "Konfirmasi Password Diperlukan!"
            } else if (konfPassword.text.toString() != password.text.toString()) {
                konfPasswordError.error = "Password Tidak Sama!"
            } else {
                Passing.setUsername(email.text.toString())
                Passing.setPassword(password.text.toString())
                Toast.makeText(this, "Berhasil Register!", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, MainActivity::class.java))
                email.text.clear()
                password.text.clear()
            }

        }


    }
}