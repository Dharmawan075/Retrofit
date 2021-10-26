package com.example.retrofit2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.response.view.*

class CommentAdapter (private val commentList: ArrayList<CommentResponse>): RecyclerView.Adapter<CommentAdapter.CommentViewHolder>() {
    inner class CommentViewHolder (itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(commentResponse: CommentResponse) {
            with (itemView) {
                val text: String = "postId: ${commentResponse.postId}\n" +
                        "Id: ${commentResponse.id}\n" +
                        "Name: ${commentResponse.name}\n" +
                        "Email: ${commentResponse.email}\n" +
                        "Body: ${commentResponse.body}"

                responseTextView.text = text
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.response, parent, false)
        return CommentViewHolder(view)
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        holder.bind(commentList[position])
    }

    override fun getItemCount(): Int = commentList.size
}