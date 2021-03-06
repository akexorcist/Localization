package com.akexorcist.localizationapp.viewpager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(manager: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(manager, lifecycle) {
    companion object {
        private const val PAGE_COUNT = 4
    }

    override fun createFragment(position: Int): Fragment = when (position) {
        0 -> OneFragment.newInstance()
        1 -> TwoFragment.newInstance()
        2 -> ThreeFragment.newInstance()
        3 -> HelloFragment.newInstance()
        else -> HelloFragment.newInstance()
    }

    override fun getItemCount(): Int = PAGE_COUNT
}
