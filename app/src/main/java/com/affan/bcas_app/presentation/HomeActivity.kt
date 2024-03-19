package com.affan.bcas_app.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.affan.bcas_app.R
import com.affan.bcas_app.databinding.ActivityHomeBinding
import com.affan.bcas_app.presentation.fragment.AdminFragment
import com.affan.bcas_app.presentation.fragment.DashboardFragment
import com.affan.bcas_app.presentation.fragment.InboxFragment
import com.affan.bcas_app.presentation.fragment.MessageFragment
import com.affan.bcas_app.utils.ConfirmationDialogUtil
import com.affan.bcas_app.utils.SharePrefHelper
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    private lateinit var confirmationDialog: ConfirmationDialogUtil
    private lateinit var sharePref: SharePrefHelper

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigationHome -> {
                replaceFragment(DashboardFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigationInbox -> {
                replaceFragment(InboxFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigationAdmin -> {
                replaceFragment(AdminFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigationMessage -> {
                replaceFragment(MessageFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigationLogout -> {
                showConfirmation()
                return@OnNavigationItemSelectedListener false
            }

        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharePref = SharePrefHelper(this)

        confirmationDialog = ConfirmationDialogUtil(this)

        binding.bottomNavigation.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
        if (savedInstanceState == null) {
            binding.bottomNavigation.selectedItemId = R.id.navigationHome
        }

    }

    private fun showConfirmation() {
        val title = "Apakah anda ingin keluar ?"
        val icon = R.drawable.ic_logout

        confirmationDialog.showConfirmationDialog(
            title = title,
            icon = icon,
            onConfirm = {
                sharePref.clearDataPref()
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            },
            onCancel = {
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            }
        )
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, fragment).commit()
    }
}