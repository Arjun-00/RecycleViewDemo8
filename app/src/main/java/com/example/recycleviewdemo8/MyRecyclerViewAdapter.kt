package com.example.recycleviewdemo8

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MyRecyclerViewAdapter(private val fruteNameList: List<Fruit>,private val clickListener: (Fruit) -> Unit) : RecyclerView.Adapter<MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItem = layoutInflater.inflate(R.layout.list_item,parent,false)
        return MyViewHolder(listItem)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       // holder.myTextView.text = fruteNameList[position].name
        holder.binding(fruteNameList[position],clickListener)
    }

    override fun getItemCount(): Int {
        return  fruteNameList.size
    }
}

class MyViewHolder(val  view : View): RecyclerView.ViewHolder(view){
//val  myTextView = view.findViewById<TextView>(R.id.tvName)

    fun binding(fruit : Fruit,clickListener: (Fruit) -> Unit){
        val  myTextView = view.findViewById<TextView>(R.id.tvName)
        myTextView.text = fruit.name
        view.setOnClickListener{
            clickListener(fruit)
            //Toast.makeText(view.context,fruit.suppliers,Toast.LENGTH_LONG).show()
        }
    }
}