package com.akexorcist.localizationapp.viewpager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class ViewPagerAdapter(manager: FragmentManager) : FragmentPagerAdapter(manager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    companion object {
        private const val PAGE_COUNT = 4
    }

    override fun getItem(position: Int): Fragment = when (position) {
        0 -> OneFragment.newInstance()
        1 -> TwoFragment.newInstance()
        2 -> ThreeFragment.newInstance()
        3 -> HelloFragment.newInstance()
        else -> HelloFragment.newInstance()
    }

    override fun getCount(): Int = PAGE_COUNT
}
