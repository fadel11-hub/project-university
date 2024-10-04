package com.example.mycourseschooloutsidecountry

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import android.widget.Toast
import com.bumptech.glide.Glide


class ListUniversity(private val listUniversity: ArrayList<University>) :RecyclerView.Adapter<ListUniversity.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_university, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listUniversity.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo) = listUniversity[position]
//        holder.imgPhoto.setImageResource(photo)
//        Glide.with(holder.itemView.context)
//            .load(photo)
//            .into(holder.imgPhoto)

        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text = name
        holder.tvDescription.text = description
        
//        holder.itemView.setOnClickListener{
//            Toast.makeText(holder.itemView.context, "Kamu memilih " + listUniversity[holder.adapterPosition].name, Toast.LENGTH_SHORT).show()
//        }

        holder.itemView.setOnClickListener{
            val content = holder.itemView.context
            val intentToDetail = Intent(content, DetailUniversity::class.java).apply {
                putExtra(DetailUniversity.EXTRA_PHOTO, photo)
                putExtra(DetailUniversity.EXTRA_NAME, name)
                putExtra(DetailUniversity.EXTRA_DESCRIPTION, description)
                    }
            content.startActivity(intentToDetail)
            onItemClickCallback.onItemClicked(listUniversity[holder.adapterPosition])}
        }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: University)
        }
    }

