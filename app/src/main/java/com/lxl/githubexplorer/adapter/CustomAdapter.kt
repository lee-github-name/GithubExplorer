package com.lxl.githubexplorer.adapter

import android.content.ClipData
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.lxl.githubexplorer.R

class CustomAdapter(private val context: Context,private val data: List<String>) : RecyclerView.Adapter<CustomAdapter.VH>() {

    private val inflater: LayoutInflater by lazy {
        LayoutInflater.from(context)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view = inflater.inflate(R.layout.item_recyler_view,parent,false)
        return VH(view)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val textView = holder.textView
        textView.text = data[position]
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class VH(view: View) : RecyclerView.ViewHolder(view){
        val textView:TextView = view.findViewById(R.id.text_view)
    }
}
