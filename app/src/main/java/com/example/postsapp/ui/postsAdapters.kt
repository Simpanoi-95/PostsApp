package com.example.postsapp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.postsapp.R
import com.example.postsapp.models.Post
import kotlinx.android.synthetic.main.row_item_post.view.*

class postsAdapters (var posts: List<Post>) : RecyclerView.Adapter<postsAdapters.PostsViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PostsViewHolder(
        var itemview=LayoutInflater.from(parent.context).inflate(R.layout.row_item_post, parent, false)
    )

    override fun getItemCount() = posts.size

    override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {
        var post = posts[position]

        holder.itemView.userId.text = post.userId.toString()
        holder.itemView.Ids.text  = post.id.toString()
        holder.itemView.title.text = post.title
        holder.itemView.body.text = post.body
        holder.rowview.setOnClickListener{
            PostItemClickListener.onItemClick(post)
        }

    }
    override fun getItemCount():Int {
        return postsList.size

    }

     class PostsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}



