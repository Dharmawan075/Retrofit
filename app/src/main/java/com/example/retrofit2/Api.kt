package com.example.retrofit2

import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("posts")
    fun getPosts(): Call<ArrayList<PostResponse>>

    @GET("posts/1/comments")
    fun getComments(): Call<ArrayList<CommentResponse>>
}