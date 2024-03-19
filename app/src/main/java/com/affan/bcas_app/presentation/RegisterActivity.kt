package com.affan.bcas_app.presentation

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.affan.bcas_app.R
import com.affan.bcas_app.presentation.LoginActivity.Companion.KEY_NAME
import com.affan.bcas_app.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private var defaultPasswordVisibility = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        // var angkasatu= 1 : yang dimana nilainya masih bisa diubah
        // val angkasatu = 1 : yang dimana nilainya tidak bisa diubah
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        handleRegister()

        binding.ivPassNormal.setOnClickListener{
            defaultPasswordVisibility = !defaultPasswordVisibility

            if (defaultPasswordVisibility) {
                binding.ivPassNormal.setImageResource(R.drawable.baseline_arrow_drop_down_24)
                binding.InputPass.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
            } else {
                binding.ivPassNormal.setImageResource(R.drawable.baseline_arrow_drop_down_circle_24)
                binding.InputPass.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
            }
        }

    }

    private fun handleRegister() {
//        val btnRegister = findViewById<Button>(R.id.ButtonSubmit)
        val etName = findViewById<EditText>(R.id.InputNama)
        val etAlamat = findViewById<EditText>(R.id.InputAlamat)
        val etPass = findViewById<EditText>(R.id.InputPass)
        val namaValue = etName.text
        val alamatValue = etAlamat.text
        val passValue = etPass.text
        binding.ButtonSubmit.setOnClickListener {

            if (namaValue.isEmpty() || passValue.isEmpty() || alamatValue.isEmpty()){
                showToast("Harap lengkapi data ya mas")
            } else {
                val intent = Intent(this, ProfileActivity::class.java)
                intent.putExtra(KEY_NAME, etName.toString())
                startActivity(intent)
            }
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}