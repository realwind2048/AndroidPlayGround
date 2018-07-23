package com.peterkim.androidplayground

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.peterkim.androidplayground.R.id.recyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.list_item_main.view.*

/**
 * Show a list of all activities(samples)
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val data: ArrayList<ButtonData> = ArrayList()
        data.add(ButtonData("Kakao API", KakaoActivity::class.java))
        data.add(ButtonData("2", MainActivity::class.java))

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ListAdapter(this, data)
    }

    class ListAdapter(val context: Context, val data: ArrayList<ButtonData>) : RecyclerView.Adapter<ListAdapter.VH>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
            return VH(LayoutInflater.from(parent.context).inflate(R.layout.list_item_main, parent, false))
        }

        override fun getItemCount() =  data.size

        override fun onBindViewHolder(holder: VH, position: Int) {
            val item = data[position]
            holder.btnActivity.text = item.name
            holder.btnActivity.setOnClickListener {
                val intent = Intent(context, item.dest)
                context.startActivity(intent)
            }
        }

        class VH(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val btnActivity = itemView.btnActivity as Button
        }
    }

    data class ButtonData(var name: String, var dest: Class<out Activity>)
}
