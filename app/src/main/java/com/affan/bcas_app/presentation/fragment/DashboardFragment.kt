package com.affan.bcas_app.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.affan.bcas_app.R
import com.affan.bcas_app.adapter.AccountNumberAdapter
import com.affan.bcas_app.adapter.PromotionAdapter
import com.affan.bcas_app.base.BaseFragment
import com.affan.bcas_app.databinding.FragmentDashboardBinding
import com.affan.bcas_app.model.AccountNumberModel
import com.affan.bcas_app.model.MenuDashboardModel
import com.affan.bcas_app.model.PromotionModel
import com.affan.bcas_app.presentation.fragment.adapter.DashboardMenuAdapter
import com.affan.bcas_app.presentation.viewmodel.DashboardViewModel
import com.affan.bcas_app.utils.HorizontalItemDecoration

class DashboardFragment : BaseFragment<FragmentDashboardBinding>() {
//    menambahkan isi variabelnya nanti sesuai dengan isi nya
    private val viewModel: DashboardViewModel by viewModels()
    private lateinit var menuAdapter: DashboardMenuAdapter
    private lateinit var accountNumberAdapter: AccountNumberAdapter
    private lateinit var promotionAdapter: PromotionAdapter

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
//        setupViewMenu()
//        setupViewAccountNumber()
        setupViewPromotion()

        viewModel.getHomeMenu()
        viewModel.getAccNumber()
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.homeMenu.observe(viewLifecycleOwner) {
            setupViewMenu(it)
        }
        viewModel.accNumber.observe(viewLifecycleOwner) {
            setupViewAccountNumber(it)
        }
    }

    private fun setupViewAccountNumber(data: List<AccountNumberModel>) {
        accountNumberAdapter = AccountNumberAdapter(data)
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

    private fun setupViewMenu(data: List<MenuDashboardModel>) {
        menuAdapter = DashboardMenuAdapter(
            menuData = data,
            context = binding.root.context
        )

        binding.componentMenu.gridMenu.adapter = menuAdapter
        binding.componentMenu.gridMenu.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _
            -> Toast.makeText(binding.root.context, data[position].menuName,
            Toast.LENGTH_SHORT).show()  }
    }

    private fun setupViewPromotion() {
        promotionAdapter = PromotionAdapter(populateDataPromo())
        binding.componentPromo.rvPromo.adapter = promotionAdapter

        binding.componentPromo.rvPromo.layoutManager =
            LinearLayoutManager(binding.root.context,
                LinearLayoutManager.HORIZONTAL, false)
        binding.componentPromo.rvPromo.apply {
            if (itemDecorationCount <= 0) {
                addItemDecoration(horizontalItemDecoration)
            }
        }
    }

    private fun populateDataPromo() : List<PromotionModel>{
        return listOf(
            PromotionModel(
                imagePromotion = R.drawable.promobcas2
            ),
            PromotionModel(
                imagePromotion = R.drawable.promobcas
            ),
            PromotionModel(
                imagePromotion = R.drawable.promobcas3
            ),
        )
    }


}