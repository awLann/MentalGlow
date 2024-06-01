package com.example.mentalglow.view.home.fragment.text

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.mentalglow.databinding.FragmentTextAnalysisBinding

class TextAnalysisFragment : Fragment() {

    private var _binding: FragmentTextAnalysisBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val textAnalysisViewModel =
            ViewModelProvider(this).get(TextAnalysisViewModel::class.java)

        _binding = FragmentTextAnalysisBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textTextAnalysis
        textAnalysisViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}