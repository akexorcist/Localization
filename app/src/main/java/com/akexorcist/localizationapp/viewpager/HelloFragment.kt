package com.akexorcist.localizationapp.viewpager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.akexorcist.localizationapp.databinding.FragmentHelloBinding

class HelloFragment : Fragment() {
    companion object {
        @JvmStatic
        fun newInstance(): Fragment = HelloFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = FragmentHelloBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
}
