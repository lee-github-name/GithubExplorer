package com.lxl.githubexplorer

import android.graphics.Color
import android.media.session.PlaybackState
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import com.lxl.githubexplorer.adapter.CustomAdapter
import com.lxl.githubexplorer.adapter.CustomAdapterWrapper

class MainActivity : AppCompatActivity() {

    private val inflater: LayoutInflater by lazy {
        LayoutInflater.from(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        val list = ArrayList<String>()
        for (i in 0..25){
            list.add(('a'+i).toString())
        }
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = CustomAdapterWrapper(inflater, CustomAdapter(this@MainActivity,list))
        }
    }

}
