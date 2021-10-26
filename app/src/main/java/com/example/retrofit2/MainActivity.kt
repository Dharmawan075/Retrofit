package com.example.retrofit2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    val list = ArrayList<PostResponse>()
    val commentList = ArrayList<CommentResponse>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.title = "Get Post with Retrofit"

//        showPosts()
        showComments()
    }

    private fun showComments() {
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)

        RetrofitClient.instance.getComments().enqueue(object : Callback<ArrayList<CommentResponse>> {
            override fun onResponse(call: Call<ArrayList<CommentResponse>>, response: Response<ArrayList<CommentResponse>>) {
                val responseCode = response.code().toString()
                responseCodeTextView.text = "Response Code: $responseCode"
                response.body()?.let { commentList.addAll(it)}

                val showCommentAdapter = CommentAdapter(commentList)
                recyclerView.adapter = showCommentAdapter
            }

            override fun onFailure(call: Call<ArrayList<CommentResponse>>, t: Throwable) {
                responseCodeTextView.text = t.message
            }

        })
    }

    private fun showPosts() {
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)

        RetrofitClient.instance.getPosts().enqueue(object : Callback<ArrayList<PostResponse>> {
            override fun onResponse(call: Call<ArrayList<PostResponse>>, response: Response<ArrayList<PostResponse>>) {
                val responseCode = response.code().toString()
                responseCodeTextView.text = "Response Code: $responseCode"
                response.body()?.let { list.addAll(it)}

                val showPostAdapter = PostResponseAdapter(list)
                recyclerView.adapter = showPostAdapter
            }

            override fun onFailure(call: Call<ArrayList<PostResponse>>, t: Throwable) {
                responseCodeTextView.text = t.message
            }

        })
    }
}