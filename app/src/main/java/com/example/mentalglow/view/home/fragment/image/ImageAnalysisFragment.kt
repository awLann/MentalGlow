package com.example.mentalglow.view.home.fragment.image

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.mentalglow.databinding.FragmentImageAnalysisBinding

class ImageAnalysisFragment : Fragment() {

    private var _binding: FragmentImageAnalysisBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val imageAnalysisViewModel =
            ViewModelProvider(this).get(ImageAnalysisViewModel::class.java)

        _binding = FragmentImageAnalysisBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textImageAnalysis
        imageAnalysisViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}