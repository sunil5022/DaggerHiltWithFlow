package com.example.flowapidemo.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.flowapidemo.Model.Post
import com.example.flowapidemo.databinding.RowPostItemBinding

class PostAdapter(private var postList: List<Post>) : RecyclerView.Adapter<PostAdapter.ViewHolder>() {

    private lateinit var binding: RowPostItemBinding

       override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
           binding = RowPostItemBinding.inflate(
               LayoutInflater.from(parent.context),
               parent,false)
           return ViewHolder(binding.root)
    }

    override fun getItemCount(): Int =
        postList.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        binding.tasks.text=postList[position].body
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    }

    fun setData(postList: List<Post>)
    {
        this.postList=postList
        notifyDataSetChanged()
    }
}
