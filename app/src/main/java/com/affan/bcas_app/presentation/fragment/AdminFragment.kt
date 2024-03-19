package com.affan.bcas_app.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.affan.bcas_app.adapter.ListTransactionAdapter
import com.affan.bcas_app.databinding.FragmentAdminBinding
import com.affan.bcas_app.model.TranscationModel


class AdminFragment : Fragment() {
    // membuat binding yg mutable
    private var _binding: FragmentAdminBinding? = null
    // membuat binding tidak nullable
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentAdminBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    // untuk memanggil variabel tanpa membuat object atau memanggil class
    companion object{
        const val TRANSACTION_KEY = "transaction_key"
    }

}