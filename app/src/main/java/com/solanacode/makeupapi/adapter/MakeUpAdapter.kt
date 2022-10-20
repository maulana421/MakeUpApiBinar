package com.solanacode.makeupapi.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.solanacode.makeupapi.databinding.ItemMakeupBinding
import com.solanacode.makeupapi.model.MakeUpItem

class MakeUpAdapter(val listmakeUp : List<MakeUpItem>): RecyclerView.Adapter<MakeUpAdapter.ViewHolder>() {

    var onDelete : ((MakeUpItem)->Unit)? = null
    var onDetail : ((MakeUpItem)->Unit)? = null
    class ViewHolder(var binding: ItemMakeupBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = ItemMakeupBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.nameProduct.text = listmakeUp!![position].name
        holder.binding.categoryProduct.text = listmakeUp!![position].category
        holder.binding.priceProdct.text = listmakeUp!![position].price.toString()
        Glide.with(holder.itemView.context).load(listmakeUp!![position].imageLink).into(holder.binding.imgProduct)
    }

    override fun getItemCount(): Int {
        return listmakeUp.size
    }
}