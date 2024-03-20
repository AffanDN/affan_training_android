package com.affan.bcas_app.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.affan.bcas_app.R
import com.affan.bcas_app.adapter.AccountNumberAdapter
import com.affan.bcas_app.base.BaseFragment
import com.affan.bcas_app.databinding.FragmentDashboardBinding
import com.affan.bcas_app.model.AccountNumberModel
import com.affan.bcas_app.model.MenuDashboardModel
import com.affan.bcas_app.presentation.fragment.adapter.DashboardMenuAdapter
import com.affan.bcas_app.utils.HorizontalItemDecoration

class DashboardFragment : BaseFragment<FragmentDashboardBinding>() {
//    menambahkan isi variabelnya nanti sesuai dengan isi nya
    private lateinit var menuAdapter: DashboardMenuAdapter
    private lateinit var accountNumberAdapter: AccountNumberAdapter

    private val horizontalItemDecoration by lazy {
        HorizontalItemDecoration(
            resources.getDimensionPixelSize(R.dimen.spacing16),
            true)
    }
    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentDashboardBinding {
        return FragmentDashboardBinding.inflate(inflater, container, false)
    }

    override fun setupView() {
        setupViewMenu()
        setupViewAccountNumber()

    }

    private fun setupViewAccountNumber() {
        accountNumberAdapter = AccountNumberAdapter(populateDataAccNumber())
        binding.componentAccNumber.rvAccountNumber.adapter = accountNumberAdapter

//        Cara buat orientasinya horizontal
        binding.componentAccNumber.rvAccountNumber.layoutManager =
            LinearLayoutManager(binding.root.context,
                LinearLayoutManager.HORIZONTAL, false)
        binding.componentAccNumber.rvAccountNumber.apply {
            if (itemDecorationCount <= 0) {
                addItemDecoration(horizontalItemDecoration)
            }
        }
    }

    private fun setupViewMenu() {
        menuAdapter = DashboardMenuAdapter(
            menuData = populateDatamenu(),
            context = binding.root.context
        )

        binding.componentMenu.gridMenu.adapter = menuAdapter
        binding.componentMenu.gridMenu.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _
            -> Toast.makeText(binding.root.context, populateDatamenu()[position].menuName,
            Toast.LENGTH_SHORT).show()  }
    }

    private fun populateDatamenu() : List<MenuDashboardModel> {
        return listOf(
            MenuDashboardModel(
                image = R.drawable.transfer_pesawat,
                menuName = "Transfer"
            ),
            MenuDashboardModel(
                image = R.drawable.pembelian_cart,
                menuName = "Pembelian"
            ),
            MenuDashboardModel(
                image = R.drawable.pembayaran_card,
                menuName = "Pembayaran"
            ),
            MenuDashboardModel(
                image = R.drawable.cardless,
                menuName = "Cardless"
            ),
            MenuDashboardModel(
                image = R.drawable.history_transaction,
                menuName = "History Transaksi"
            ),
            MenuDashboardModel(
                image = R.drawable.mutasi_rekening,
                menuName = "Mutasi Rekening"
            ),
            MenuDashboardModel(
                image = R.drawable.jadwal_shalat,
                menuName = "Jadwal Shalat"
            ),
        )
    }

    private fun populateDataAccNumber() :List<AccountNumberModel> {
        return listOf(
            AccountNumberModel(
                savingType = "Tahapan Wadi'ah Non Bonus",
                noRek = 1223334444,
                balanceAmount = "Rp.100.000.000"
            ),
            AccountNumberModel(
                savingType = "Tahapan Wadi'ah Bonus",
                noRek = 1223334444,
                balanceAmount = "Rp.200.000.000"
            ),
            AccountNumberModel(
                savingType = "Tahapan Wadi'ah Bonus",
                noRek = 1223334444,
                balanceAmount = "Rp.300.000.000"
            ),
        )
    }

}