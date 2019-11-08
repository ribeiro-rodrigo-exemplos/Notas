package com.rodrigoribeiro.agenda.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rodrigoribeiro.agenda.R
import com.rodrigoribeiro.agenda.data.Nota
import kotlinx.android.synthetic.main.item_nota.view.*


class NotasViewHpolder(val view: View): RecyclerView.ViewHolder(view){

    fun bindView(item: Nota){
        with(view){
            tv_nota.text = item.text
        }

    }
}

class NotasAdapter(val data: MutableList<Nota> = mutableListOf()):
    RecyclerView.Adapter<NotasViewHpolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotasViewHpolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_nota,
            parent, false)
        return NotasViewHpolder(view)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: NotasViewHpolder, position: Int) =
        holder.bindView(data[position])

    fun add(item: Nota){
        data.add(item)
        notifyDataSetChanged()
    }

    fun add(itens: List<Nota>){
        data.clear()
        data.addAll(itens)
        notifyDataSetChanged()
    }

    fun remove(item: Nota){
        data.remove(item)
        notifyDataSetChanged()
    }
}
