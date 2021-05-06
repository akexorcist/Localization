package com.akexorcist.localizationapp.nestedfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.akexorcist.localizationapp.databinding.FragmentNestedChildBinding

class ChildFragment : Fragment() {
    private lateinit var binding: FragmentNestedChildBinding

    companion object {
        private const val KEY_SCROLL_Y = "scroll_y"
        fun newInstance(): Fragment = ChildFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentNestedChildBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        if (savedInstanceState != null) {
            // Restore y-position of scroll view.
            binding.svAppleStory.scrollTo(0, savedInstanceState.getInt(KEY_SCROLL_Y))
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        // Save y-position of scroll view.
        outState.putInt(KEY_SCROLL_Y, binding.svAppleStory.scrollY)
        super.onSaveInstanceState(outState)
    }
}
