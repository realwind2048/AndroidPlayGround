package com.peterkim.androidplayground.ui.kakao

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.peterkim.androidplayground.R
import com.peterkim.androidplayground.entity.Image
import com.squareup.picasso.Picasso

class MyAdapter : RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    private val TAG = MyAdapter::class.java.simpleName
    private var images: MutableList<Image> = ArrayList()

    class ViewHolder(v: ViewGroup) : RecyclerView.ViewHolder(v) {
        var container: ViewGroup
        var ivThumb: ImageView
        var tvTitle: TextView
        var tvDateTime: TextView

        init {
            container = v.findViewById(R.id.container)
            ivThumb = v.findViewById(R.id.ivThumb)
            tvTitle = v.findViewById(R.id.tvTitle)
            tvDateTime = v.findViewById(R.id.tvDateTime)
        }

    }

    fun setItems(dataset: MutableList<Image>?) {
        if (dataset != null) {
            images = dataset
            Log.d(TAG, "setItems dataset = " + dataset.size)
            notifyDataSetChanged()
        }
    }

    fun addItems(dataset: List<Image>?) {
        if (dataset != null) {
            images?.addAll(dataset)
            Log.d(TAG, "addItems dataset = " + dataset.size)
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_media, parent, false) as ViewGroup
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val media = images?.get(position)
        var title = ""
        var thumbUrl = ""
        var datetime = ""
        val image = media as Image
        title = image.getCollection()
        thumbUrl = image.getThumbnailUrl()
        datetime = image.getDatetime()
        //            Log.d(TAG, "position = " + position + " isFavorite = " + isFavorite);
        holder.tvTitle.text = title
        Picasso.get().load(thumbUrl).into(holder.ivThumb)
        holder.tvDateTime.text = datetime
        holder.container.setOnClickListener(View.OnClickListener {

        })
    }

    override fun getItemCount(): Int {
        return images?.size ?: 0
    }
}