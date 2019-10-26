package com.example.sport

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {

    private val items: MutableList<Item> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list = findViewById<RecyclerView>(R.id.sport_list)
        initDATA()

        list.layoutManager = LinearLayoutManager(this)
        list.adapter = RecyclerViewAdapter( this, items)

    }

    private fun initDATA(){
        val name = resources.getStringArray(R.array.sport_name)
        val image = resources.obtainTypedArray(R.array.sport_image)

        items.clear()

        for (i in name.indices) {
            items.add(
                Item(name[i],
                    image.getResourceId(i, 0)))

        }
        image.recycle()
    }
}
