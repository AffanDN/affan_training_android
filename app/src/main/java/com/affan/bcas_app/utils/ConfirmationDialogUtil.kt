package com.affan.bcas_app.utils

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import com.affan.bcas_app.R
import com.affan.bcas_app.databinding.DialogLayoutBinding

class ConfirmationDialogUtil(private val context: Context) {

    fun showConfirmationDialog(
        title: String,
        icon: Int? = null,
        onConfirm: () -> Unit,
        onCancel: () -> Unit,
    ) {
        val dialogBuilder = AlertDialog.Builder(context)
        val alertDialog = dialogBuilder.create()

        val dialogView = LayoutInflater.from(context).inflate(R.layout.dialog_layout, null)
        val binding = DialogLayoutBinding.bind(dialogView)

        binding.tvTitle.text = title

        if (icon != null) {
            binding.ivIconDialog.visibility = View.VISIBLE
            binding.ivIconDialog.setImageResource(icon)
        } else {
            binding.ivIconDialog.visibility = View.GONE
        }

        alertDialog.setView(dialogView)

        binding.btnYes.setOnClickListener {
            onConfirm.invoke()
            alertDialog.dismiss()
        }

        binding.btnNo.setOnClickListener {
            onCancel.invoke()
            alertDialog.dismiss()
        }

        alertDialog.show()
    }
}