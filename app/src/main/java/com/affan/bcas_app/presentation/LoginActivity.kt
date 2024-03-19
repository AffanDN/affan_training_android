package com.affan.bcas_app.presentation

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.affan.bcas_app.R
import com.affan.bcas_app.databinding.ActivityLoginBinding
import com.affan.bcas_app.utils.SharePrefHelper
import java.util.UUID

class LoginActivity : AppCompatActivity() {
    private lateinit var binding : ActivityLoginBinding
//    manggil objeknya
    private lateinit var sharePref: SharePrefHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        // var angkasatu= 1 : yang dimana nilainya masih bisa diubah
        // val angkasatu = 1 : yang dimana nilainya tidak bisa diubah
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharePref = SharePrefHelper(this)
        checkToken()
        handleClick()

//        val tvProfile = findViewById<Button>(R.id.ButtonLogin)
//        tvProfile.setOnClickListener {
//            handleProfile()
//        }
    }

    private fun handleClick() {
        binding.cbPass.setOnClickListener{
            val cbPass = binding.cbPass
            if (cbPass.isChecked) {
                binding.InputPass.inputType = InputType.TYPE_CLASS_TEXT
            } else {
                binding.InputPass.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
            }
        }

        binding.ButtonLogin.setOnClickListener{
            if (binding.InputNama.text.isEmpty().not() && binding.InputPass.text.isEmpty().not()){
                val token = UUID.randomUUID().toString()
                sharePref.saveToken(token)
                handleLogin()
            } else {
                showToast("Harap lengkapi username dan password")
            }
        }

//        val tvRegister = findViewById<TextView>(R.id.tvRegister)
        binding.tvRegister.setOnClickListener{
            handleRegister()
        }
    }

    private fun checkToken() {
        val getToken = sharePref.getToken()
        if(getToken.isNotEmpty()) {
            handleLogin()
        }
    }

    private fun handleLogin(){
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }

    private fun handleProfile() {
        val intent = Intent(this, ProfileActivity::class.java)
        startActivity(intent)
    }


    private fun handleRegister() {
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
        // finish() = jika activity nya telah dijalankan maka tidak bisa back
        // kembali atau dikembalikan ke home
        // finish()
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    companion object {
        const val KEY_NAME = "key_name"
        const val  KEY_ADDRESS = "key_address"
    }
}