package com.affan.bcas_app.presentation.fragment.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.affan.bcas_app.R
import com.affan.bcas_app.model.MenuDashboardModel

class DashboardMenuAdapter(
    private val menuData: List<MenuDashboardModel>,
    private val context: Context
) : BaseAdapter() {
    private var image: ImageView? = null
    private var textmanu: TextView? = null
    private var layoutIflater: LayoutInflater? = null
    override fun getCount(): Int {
        return menuData.size
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

        image = bindingView?.findViewById(R.id.ivMenu)
        textmanu = bindingView?.findViewById(R.id.tvMenu)

//        ini fungsinya untuk mendapatkan data
//        dari list berdasarkan posisi
        val resultMenu = menuData[position]

//        ini fungsinya untuk melakukan set pada
//        masing2 component di layout
        image?.setImageResource(resultMenu.image)
        textmanu?.text = resultMenu.menuName

        return  bindingView
    }

}