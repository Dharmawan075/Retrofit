package com.example.retrofit2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.response.view.*

class PostResponseAdapter(private val list: ArrayList<PostResponse>): RecyclerView.Adapter<PostResponseAdapter.PostViewHolder>() {
    inner class PostViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(postResponse: PostResponse) {
            with(itemView) {
                val text: String = "userId: ${postResponse.userId}\n" +
                        "Id: ${postResponse.id}\n" +
                        "Title: ${postResponse.title}\n" +
                        "Body: ${postResponse.body}"

                responseTextView.text = text
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.response, parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size
}