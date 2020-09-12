package com.example.kotlintest.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlintest.R
import com.example.kotlintest.databinding.RecyclerItemBinding
import com.example.kotlintest.model.Pais

class Adapter(private var items : ArrayList<Pais>, var listener: (String) -> Unit) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        items[position].nombre?.let { holder.bind(it, listener) }
        items[position].nombre?.let { holder.bind(it) }
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val binding = RecyclerItemBinding.bind(view)

        fun bind(text : String) {
            with(binding) {
                texto.text = text
                root.setOnClickListener { listener(text) }
            }
        }

    }

    fun actualizarPaises(paises: List<Pais>) {
        items.clear()
        items.addAll(paises)
        notifyDataSetChanged()
    }

}