package com.example.avengersapp

import android.content.Intent
import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView

class AvengersAdapter(var listAvengers: List<Avenger>) : RecyclerView.Adapter<AvengersAdapter.AvengerViewHolder>() {

    class AvengerViewHolder(var root: View, val foto: ImageView, val name: TextView, val estrellas: ImageView) : RecyclerView.ViewHolder(root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AvengerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.itemavenger, parent, false)
        val foto = view.findViewById<ImageView>(R.id.foto)
        val twName = view.findViewById<TextView>(R.id.name)
        val estrellas = view.findViewById<ImageView>(R.id.estrellas)

        return AvengerViewHolder(view, foto, twName, estrellas)
    }

    override fun getItemCount(): Int {
        return listAvengers.size
    }

    override fun onBindViewHolder(holder: AvengerViewHolder, position: Int) {
        holder.name.text = listAvengers[position].name
        holder.foto.setImageResource(listAvengers[position].foto)
        holder.estrellas.setImageResource(listAvengers[position].estrellas)

        holder.foto.setOnClickListener{
            val intent = Intent(holder.foto.context, DescriptionActivity::class.java)
            intent.putExtra("VALOR1", listAvengers[position])
            holder.foto.context.startActivity(intent)
        }
    }

    fun updateAvengers(newData: List<Avenger>){
        listAvengers = newData
        notifyDataSetChanged()
    }
}