package com.example.dagger2retrofit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dagger2retrofit.model.Data
import com.squareup.picasso.Picasso

class MainAdapter :RecyclerView.Adapter<MainAdapter.ViewHolder>(){
private var data= emptyList<Data>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.name.text=data[position].name
       holder.city.text=data[position].city
       holder.country.text=data[position].country
       Picasso.get().load(data[position].imgURL).into(holder.image)
    }

    class ViewHolder(view:View):RecyclerView.ViewHolder(view){
        val name=view.findViewById<TextView>(R.id.name)
        val country=view.findViewById<TextView>(R.id.country)
        val city=view.findViewById<TextView>(R.id.city)
        val image=view.findViewById<ImageView>(R.id.imageView)
    }

    fun setData(list:List<Data>){
        data=list
        notifyDataSetChanged()
    }

}