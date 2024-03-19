package com.affan.bcas_app.presentation.fragment.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.affan.bcas_app.R

class DashboardMenuAdapter(
    private val context: Context
) : BaseAdapter() {
    private var layoutIflater: LayoutInflater? = null
    override fun getCount(): Int {
        return 0
    }

    override fun getItem(position: Int): Any? {
        return null
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, viewGroup: ViewGroup?): View? {
        var bindingView = convertView
        if (layoutIflater == null) {
            layoutIflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        }

        if (bindingView == null) {
            bindingView = layoutIflater?.inflate(R.layout.item_menu_dashboard, null)
        }

        return  bindingView
    }

}