package com.akexorcist.localizationapp.simpledialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.akexorcist.localizationapp.databinding.FragmentSimpleDialogContentBinding

class SimpleDialogContentFragment : DialogFragment() {
    private lateinit var binding: FragmentSimpleDialogContentBinding

    companion object {
        fun newInstance(): SimpleDialogContentFragment = SimpleDialogContentFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSimpleDialogContentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
}
