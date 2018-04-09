package com.lxl.githubexplorer.adapter

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lxl.githubexplorer.R

class CustomAdapterWrapper(
        private val inflater: LayoutInflater,
        private val customAdapter: CustomAdapter) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){


    enum class ItemViewType{
        Normal,
        Header,
        Footer,
    }

    override fun getItemViewType(position: Int): Int {
        return when (position){
            0 -> ItemViewType.Header.ordinal
            customAdapter.itemCount+1 -> ItemViewType.Footer.ordinal
            else -> ItemViewType.Normal.ordinal
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val headerView = inflater.inflate(R.layout.footer,parent,false)
        val footerView = inflater.inflate(R.layout.footer,parent,false)
       return when(viewType){
                ItemViewType.Header.ordinal -> object : RecyclerView.ViewHolder(headerView){}
                ItemViewType.Footer.ordinal -> object : RecyclerView.ViewHolder(footerView){}
           else -> customAdapter.onCreateViewHolder(parent,viewType)
        }

    }

    override fun getItemCount(): Int {
        return customAdapter.itemCount + 2
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(position){
            0 -> return
            customAdapter.itemCount+1 -> return
            else -> customAdapter.onBindViewHolder(holder as CustomAdapter.VH,position-1)
        }

    }
}
