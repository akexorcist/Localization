package com.akexorcist.localizationapp.nestedfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.akexorcist.localizationapp.databinding.FragmentNestedParentBinding

class ParentFragment : Fragment() {
    private lateinit var binding: FragmentNestedParentBinding

    companion object {
        fun newInstance(): Fragment = ParentFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentNestedParentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            parentFragmentManager.commit {
                replace(binding.layoutChildFragmentContainer.id, ChildFragment.newInstance())
            }
        }
    }
}
