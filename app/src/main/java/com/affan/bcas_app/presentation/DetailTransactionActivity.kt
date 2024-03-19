package com.affan.bcas_app.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.affan.bcas_app.R
import com.affan.bcas_app.databinding.ActivityDetailTransactionBinding
import com.affan.bcas_app.model.TranscationModel
import com.affan.bcas_app.presentation.ListTransactionActivity.Companion.TRANSACTION_KEY

class DetailTransactionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailTransactionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailTransactionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val transaction = intent.getParcelableExtra<TranscationModel>(TRANSACTION_KEY)
        binding.TransferDate.text = transaction?.date
        binding.TransferType.text = transaction?.transferType
        binding.TransferDestination.text = transaction?.transferDestination
        binding.tvStatusTransaction.text = transaction?.transferStatus
        binding.tvAmount.text = transaction?.amount.toString()
    }
}