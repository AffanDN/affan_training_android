package com.affan.bcas_app.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

// untuk buat tab kiri kanan
class MessageTabAdapter(
    fragment: Fragment,
    ) : FragmentStateAdapter
    (fragment.childFragmentManager,
    fragment.lifecycle) {

    private val fragmentContent = arrayListOf<Fragment>()

    fun addListFragment(fragment: Fragment) {
        fragmentContent.add(fragment)
    }

    override fun getItemCount() = fragmentContent.size

    override fun createFragment(position: Int): Fragment {
        return fragmentContent[position]
    }
}