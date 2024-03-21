package com.affan.bcas_app.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.affan.bcas_app.R
import com.affan.bcas_app.model.AccountNumberModel
import com.affan.bcas_app.model.MenuDashboardModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DashboardViewModel : ViewModel() {

    // membuat 2 variabel yang mana _homemenu untuk memproses logic
    // dan homemenu untuk menampung hasil return valuenya keluar
    private val _homeMenu = MutableLiveData<List<MenuDashboardModel>>()
    val homeMenu: LiveData<List<MenuDashboardModel>>
        get() = _homeMenu

    private val _accNumber = MutableLiveData<List<AccountNumberModel>>()

    val accNumber: LiveData<List<AccountNumberModel>>
        get() = _accNumber

    private fun populateDataAccNumber() :List<AccountNumberModel> {
        return listOf(
            com.affan.bcas_app.model.AccountNumberModel(
                savingType = "Tahapan Wadi'ah Non Bonus",
                noRek = 1223334444,
                balanceAmount = "Rp.100.000.000"
            ),
            com.affan.bcas_app.model.AccountNumberModel(
                savingType = "Tahapan Wadi'ah Bonus",
                noRek = 1223334444,
                balanceAmount = "Rp.200.000.000"
            ),
            com.affan.bcas_app.model.AccountNumberModel(
                savingType = "Tahapan Wadi'ah Bonus",
                noRek = 1223334444,
                balanceAmount = "Rp.300.000.000"
            ),
        )
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
    fun getHomeMenu() = viewModelScope.launch(Dispatchers.IO) {
        _homeMenu.postValue(populateDatamenu())
    }
    fun getAccNumber() = viewModelScope.launch(Dispatchers.IO) {
        _accNumber.postValue(populateDataAccNumber())
    }
}