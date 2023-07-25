package com.barabaraberi.whitecurency

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class CustomAdapter (private val context: Context, private val items: List<CustomItem>) : ArrayAdapter<CustomItem>(context, R.layout.list_item, items) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val itemView: View = convertView ?: LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)

        val currentItem = items[position]

        val firstn: TextView = itemView.findViewById(R.id.firstnum)
        val secondn: TextView = itemView.findViewById(R.id.secondnum)
        val firstc:View=itemView.findViewById(R.id.view1)
        val secondc:View=itemView.findViewById(R.id.view2)

        firstn.text=currentItem.num1
        secondn.text=currentItem.num2
        firstc.setBackgroundResource(currentItem.im1)
        secondc.setBackgroundResource(currentItem.im2)

        return itemView
    }
}

class CustomItem(val num1: String, val num2: String,val im1:Int,val im2:Int)