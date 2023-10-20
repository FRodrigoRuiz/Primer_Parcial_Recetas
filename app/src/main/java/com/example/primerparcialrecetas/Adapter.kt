package com.example.primerparcialrecetas

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class Adapter(val context: Context) : ListAdapter<Receta, Adapter.ViewHolder>(DiffCallBack) {

    lateinit var onItemClickListener: (Receta) -> Unit

    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        private val nombre: TextView = view.findViewById(R.id.tv_nombre)
        private val dificultad: TextView = view.findViewById(R.id.tv_dificultad)
        private val pais: TextView = view.findViewById(R.id.tv_pais)
        private val imagen: ImageView = view.findViewById(R.id.iv_imagen_receta)

        fun bind (receta: Receta) {

            nombre.text = receta.nombre
            dificultad.text = receta.dificultad.toString()
            pais.text = receta.pais

            Glide.with(context).load(receta.imagen).into(imagen)

            view.setOnClickListener {
                onItemClickListener(receta)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: Adapter.ViewHolder, position: Int) {
        val receta = getItem(position)
        holder.bind(receta)
    }

    companion object DiffCallBack : DiffUtil.ItemCallback<Receta>() {
        override fun areItemsTheSame(oldItem: Receta, newItem: Receta): Boolean {
            return  oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Receta, newItem: Receta): Boolean {
            return oldItem == newItem
        }
    }
}