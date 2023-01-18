package com.example.taomlarroom.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.taomlarroom.R
import com.example.taomlarroom.Taomlar
import com.example.taomlarroom.databinding.ItemTaomBinding

class AdapterTaomlar(private val list: ArrayList<Taomlar>, val onClickListener: OnClickListener) :
    RecyclerView.Adapter<AdapterTaomlar.MyViewHolder>() {
    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun onBind(taomlar: Taomlar, position: Int) {
            val bind = ItemTaomBinding.bind(itemView)
            bind.nameErvi.text = taomlar.name

            bind.delete.setOnClickListener {
                onClickListener.itemRemove(taomlar, position)
            }
            bind.updete.setOnClickListener {
                onClickListener.itemEdit(taomlar, position)
            }
            bind.cons.setOnClickListener {
                onClickListener.onClic(taomlar,position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_taom, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.onBind(list[position], position)
    }

    override fun getItemCount(): Int = list.size

    interface OnClickListener {
        fun itemRemove(taomlar: Taomlar, position: Int)
        fun itemEdit(taomlar: Taomlar, position: Int)
        fun onClic(taomlar: Taomlar, position: Int)
    }
}