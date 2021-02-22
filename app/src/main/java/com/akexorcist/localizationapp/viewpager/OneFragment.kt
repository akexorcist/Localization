package com.akexorcist.localizationapp.viewpager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.akexorcist.localizationapp.databinding.FragmentOneBinding

class OneFragment : Fragment() {
    companion object {
        @JvmStatic
        fun newInstance(): Fragment = OneFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = FragmentOneBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
}