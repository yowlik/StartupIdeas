package com.ssthaeasoo.gumangr.whitewallet


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class WalletAdapter (private val context: Context, private val items: List<Item>) : ArrayAdapter<Item>(context, R.layout.item, items) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val itemView: View = convertView ?: LayoutInflater.from(context).inflate(R.layout.item, parent, false)

        val currentItem = items[position]

        val namer: TextView = itemView.findViewById(R.id.companyname)
        val fullname: TextView = itemView.findViewById(R.id.companyfull)
        val perc: TextView =itemView.findViewById(R.id.plusproc)
        val price: TextView =itemView.findViewById(R.id.fullprice)
        val graphik: View=itemView.findViewById(R.id.graph)

        namer.text=currentItem.name
        fullname.text=currentItem.fullname
        perc.text=currentItem.pers
        price.text=currentItem.price
        graphik.setBackgroundResource(currentItem.gras)
        return itemView
    }
}

