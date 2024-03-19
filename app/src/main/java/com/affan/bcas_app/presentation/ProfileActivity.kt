package com.affan.bcas_app.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.affan.bcas_app.presentation.LoginActivity.Companion.KEY_NAME
import com.affan.bcas_app.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {
    private lateinit var binding : ActivityProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val getName = intent.getStringExtra(KEY_NAME)

        binding.tvNama2.text = getName
        binding.vComponentTopbar.tvTitle.text = "Profile Feature"
        binding.vComponentTopbar.ivBack.setOnClickListener{
            onBackPressed()
        }
    }

}