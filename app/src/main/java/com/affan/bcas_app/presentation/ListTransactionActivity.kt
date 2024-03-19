package com.affan.bcas_app.presentation

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.affan.bcas_app.adapter.ListTransactionAdapter
import com.affan.bcas_app.databinding.ActivityListTransactionBinding
import com.affan.bcas_app.model.TranscationModel


class ListTransactionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityListTransactionBinding
    private var listTransactionAdapter = ListTransactionAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListTransactionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvListTransaction.adapter = listTransactionAdapter
        listTransactionAdapter.setData(createDummyListTransaction())
        listTransactionAdapter.setOnClickTransaction { transaction -> navigateToDetailTransaction(transaction) }
    }

    private fun navigateToDetailTransaction(data: TranscationModel) {
        val intent = Intent(this, DetailTransactionActivity::class.java)
        intent.putExtra(TRANSACTION_KEY, data)
        startActivity(intent)
    }

    private fun createDummyListTransaction() : MutableList<TranscationModel> {
        return mutableListOf(
            TranscationModel(
                transferType = "Pembayaran QR",
                transferDestination = "QR Mang Soleh",
                date = "01/03/2024",
                transferStatus = "Success",
                amount = 100000.0
        ),
            TranscationModel(
                transferType = "Transfer BRI",
                transferDestination = "BRI",
                date = "07/03/2024",
                transferStatus = "Failed",
                amount = 73000.0
            ), TranscationModel(
                transferType = "Pembayaran QRJB",
                transferDestination = "QR PT. Jahit baju",
                date = "21/02/2024",
                transferStatus = "Failed",
                amount = 21000.0
            ), TranscationModel(
                transferType = "Pembayaran QRJC",
                transferDestination = "QR PT. Jahit Celana",
                date = "05/03/2024",
                transferStatus = "Success",
                amount = 90000.0
            ), TranscationModel(
                transferType = "Transfer BRI",
                transferDestination = "BRI",
                date = "07/03/2024",
                transferStatus = "Failed",
                amount = 73000.0
            ), TranscationModel(
                transferType = "Pembayaran QR",
                transferDestination = "QR PT. Jahit baju",
                date = "21/02/2024",
                transferStatus = "Failed",
                amount = 21000.0
            ), TranscationModel(
                transferType = "Pembayaran QR",
                transferDestination = "QR PT. Jahit Celana",
                date = "05/03/2024",
                transferStatus = "Success",
                amount = 90000.0
            ), TranscationModel(
                transferType = "Transfer BRI",
                transferDestination = "BRI",
                date = "07/03/2024",
                transferStatus = "Failed",
                amount = 73000.0
            ), TranscationModel(
                transferType = "Pembayaran QR",
                transferDestination = "QR PT. Jahit baju",
                date = "21/02/2024",
                transferStatus = "Failed",
                amount = 21000.0
            ), TranscationModel(
                transferType = "Pembayaran QR",
                transferDestination = "QR PT. Jahit Celana",
                date = "05/03/2024",
                transferStatus = "Success",
                amount = 90000.0
            )
        )
    }
    companion object {
        const val TRANSACTION_KEY = "transaction_key"
    }
}