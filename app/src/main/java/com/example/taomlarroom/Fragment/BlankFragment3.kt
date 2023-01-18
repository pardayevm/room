package com.example.taomlarroom.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.taomlarroom.R
import com.example.taomlarroom.Taomlar
import com.example.taomlarroom.databinding.FragmentBlank3Binding

class BlankFragment3 : Fragment() {
    lateinit var binding: FragmentBlank3Binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_blank3, container, false)
        binding = FragmentBlank3Binding.bind(view)

        val taomlat = arguments?.getSerializable("taom") as Taomlar

        binding.nameTaom.text = taomlat.name
        binding.KerakliMaxsulotlar.text = taomlat.masaliq
        binding.taomTayorlashJarayoni.text = taomlat.tat

        return view
    }
}