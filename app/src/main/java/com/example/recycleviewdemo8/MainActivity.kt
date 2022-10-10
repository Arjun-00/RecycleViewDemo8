package com.example.recycleviewdemo8

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    val fruteNameList = listOf<Fruit>(
        Fruit("APPLE","Joa"),
        Fruit("MANGO","Mosa"),
        Fruit("BANANA","Tom"),
        Fruit("JACK","Jerry"),
        Fruit("DRAGON","Mas"),
        Fruit("KIVI","Dude")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
      //  val fruteNameList = listOf<String>("APPLE","MANGO","BANANA","JACK","DRAGON","MOTO","KIVI")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.myRecyclerView)
        recyclerView.setBackgroundColor(Color.BLACK)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = MyRecyclerViewAdapter(fruteNameList) { selectedItem: Fruit ->
            listItemClicked(selectedItem)
        }
    }

    private  fun  listItemClicked(fruit: Fruit){
        Toast.makeText(this,fruit.suppliers, Toast.LENGTH_LONG).show()
    }
}