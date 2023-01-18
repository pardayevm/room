package com.example.taomlarroom.Fragment

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.taomlarroom.DataBase.TaomDao
import com.example.taomlarroom.DataBase.UserDatabase
import com.example.taomlarroom.R
import com.example.taomlarroom.Taomlar
import com.example.taomlarroom.adapter.AdapterTaomlar
import com.example.taomlarroom.databinding.FragmentBlank2Binding

class BlankFragment2 : Fragment() {
    lateinit var binding: FragmentBlank2Binding
    lateinit var adapterTaomlar: AdapterTaomlar
    lateinit var userDatabase: UserDatabase
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_blank2, container, false)
        binding = FragmentBlank2Binding.bind(view)


        return view
    }

    override fun onResume() {
        super.onResume()

        userDatabase = UserDatabase.getInstance(requireContext())
        val taomDao: TaomDao = userDatabase.taomlar()
        val list = taomDao.getAllTaoms() as ArrayList

        adapterTaomlar = AdapterTaomlar(list, object : AdapterTaomlar.OnClickListener {
            override fun itemRemove(taomlar: Taomlar, position: Int) {
                val alertDialog = AlertDialog.Builder(requireContext())
                alertDialog.setTitle("Uchirish")
                alertDialog.setMessage("${taomlar.name} nomli taom uchirilsinmi ?")
                alertDialog.setCancelable(true)
                alertDialog.setPositiveButton("Ha uchirilsin",
                    object : DialogInterface.OnClickListener {
                        override fun onClick(p0: DialogInterface?, p1: Int) {
                            taomDao.deleteTaomlar(taomlar)
                            list.removeAt(position)
                            adapterTaomlar.notifyItemRemoved(position)
                            adapterTaomlar.notifyItemChanged(position, list.size)
                        }
                    })
                alertDialog.show()
            }

            override fun itemEdit(taomlar: Taomlar, position: Int) {
                val bundle = Bundle()
                bundle.putSerializable("name", taomlar)
                bundle.putString("type","update")

                findNavController().navigate(R.id.blankFragment1, bundle)
            }

            override fun onClic(taomlar: Taomlar, position: Int) {
                val bundle = Bundle().apply {
                    putSerializable("taom",taomlar)
                }
                findNavController().navigate(R.id.blankFragment3, bundle)
            }
        })
        binding.ervi.adapter = adapterTaomlar
    }
}