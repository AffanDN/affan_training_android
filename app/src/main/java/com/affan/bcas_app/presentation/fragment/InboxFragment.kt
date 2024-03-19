package com.affan.bcas_app.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.affan.bcas_app.adapter.ListTransactionAdapter
import com.affan.bcas_app.databinding.FreagmentInboxBinding
import com.affan.bcas_app.model.TranscationModel

class InboxFragment : Fragment() {
    private var _binding: FreagmentInboxBinding? = null
    private val binding get() = _binding!!
    private var listTransactionAdapter = ListTransactionAdapter()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FreagmentInboxBinding.inflate(inflater, container, false)
        binding.rvListTransaction.adapter = listTransactionAdapter
        listTransactionAdapter.setData(createDummyListTransaction())
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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
}