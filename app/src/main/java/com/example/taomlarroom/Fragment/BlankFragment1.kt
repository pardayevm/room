package com.example.taomlarroom.Fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.taomlarroom.DataBase.TaomDao
import com.example.taomlarroom.DataBase.UserDatabase
import com.example.taomlarroom.R
import com.example.taomlarroom.Taomlar
import com.example.taomlarroom.databinding.FragmentBlank1Binding
import kotlin.math.log

class BlankFragment1 : Fragment() {
    lateinit var binding: FragmentBlank1Binding
    lateinit var database: UserDatabase
    lateinit var name: Taomlar
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_blank1, container, false)
        binding = FragmentBlank1Binding.bind(view)
        val type = arguments?.getString("type")

        name = arguments?.getSerializable("name") as Taomlar

        binding.editTaomlarName.setText(name.name)
        binding.editTtt.setText(name.tat)
        binding.editMh.setText(name.masaliq)

        database = UserDatabase.getInstance(requireContext())
        val userDao: TaomDao = database.taomlar()
        val list = userDao.getAllTaoms() as ArrayList

        binding.btnAdd.setOnClickListener {
            if (type == "add") {
                if (binding.editTaomlarName.text.isNotBlank() && binding.editTtt.text.isNotBlank() && binding.editMh.text.isNotBlank()) {
                    val name = binding.editTaomlarName.text.toString()
                    val mh = binding.editMh.text.toString()
                    val ttt = binding.editTtt.text.toString()
                    val taomlar = Taomlar(name, mh, ttt)

                    userDao.addTaomlar(taomlar)
                    val id = userDao.getTaomlarById(name)
                    taomlar.id = id
                    list.add(taomlar)
                    Toast.makeText(requireContext(), "Malumot qushildi", Toast.LENGTH_SHORT)
                        .show()

                    binding.editMh.text.clear()
                    binding.editTtt.text.clear()
                    binding.editTaomlarName.text.clear()
                } else {
                    Toast.makeText(requireContext(), "Malumot kiritilmagan", Toast.LENGTH_SHORT)
                        .show()
                }
            } else {
                val name1 = binding.editTaomlarName.text.toString()
                val mt = binding.editMh.text.toString()
                val ttt1 = binding.editTtt.text.toString()
                // val taomalr = Taom(...) // id = null

                name.apply {
                    name = name1
                    tat = ttt1
                    masaliq = mt
                }

                userDao.editTaomlar(name)
                Toast.makeText(requireContext(), "Malumotlat uzgerdi", Toast.LENGTH_SHORT)
                    .show()

                findNavController().popBackStack()
            }
        }
        return view
    }
}