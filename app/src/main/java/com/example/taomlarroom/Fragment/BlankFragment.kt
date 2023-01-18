package com.example.taomlarroom.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.taomlarroom.R
import com.example.taomlarroom.databinding.FragmentBlankBinding

class BlankFragment : Fragment() {
    lateinit var binding: FragmentBlankBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_blank, container, false)
        binding = FragmentBlankBinding.bind(view)

        binding.btnMenu.setOnClickListener {
            findNavController().navigate(R.id.blankFragment2)
        }

        binding.btnTaomlar.setOnClickListener {
            val bundle = Bundle().apply {
                putString("type","add")
            }
            findNavController().navigate(R.id.blankFragment1,bundle)
        }

        return view
    }
}