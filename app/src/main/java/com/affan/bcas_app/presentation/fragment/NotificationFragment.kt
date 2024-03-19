package com.affan.bcas_app.presentation.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import com.affan.bcas_app.base.BaseFragment
import com.affan.bcas_app.databinding.FragmentHistoryBinding

import com.affan.bcas_app.databinding.FragmentNotificationBinding

class NotificationFragment : BaseFragment<FragmentNotificationBinding>() {
    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentNotificationBinding {
        return FragmentNotificationBinding.inflate(inflater, container, false)
    }

    override fun setupView() {

    }
}