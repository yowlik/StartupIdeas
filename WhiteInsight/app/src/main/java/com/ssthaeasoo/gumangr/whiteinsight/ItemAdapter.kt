package com.ssthaeasoo.gumangr.whiteinsight

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class ItemAdapter (private val context: Context, private val items: List<Item>) : ArrayAdapter<Item>(context, R.layout.item, items) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val itemView: View = convertView ?: LayoutInflater.from(context).inflate(R.layout.item, parent, false)

        val currentItem = items[position]

        val name: TextView = itemView.findViewById(R.id.companyname)
        val fullname: TextView = itemView.findViewById(R.id.companyfull)
        val perc: TextView =itemView.findViewById(R.id.plusproc)
        val price: TextView =itemView.findViewById(R.id.fullprice)

        name.text=currentItem.name
        fullname.text=currentItem.fullname
        perc.text=currentItem.pers
        price.text=currentItem.price

        return itemView
    }
}

class Item(val name: String, val fullname: String,val pers:String,val price:String)