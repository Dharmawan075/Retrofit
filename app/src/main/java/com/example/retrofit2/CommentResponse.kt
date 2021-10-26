package com.example.retrofit2

data class CommentResponse (
        val postId: Int,
        val id: Int,
        val name: String,
        val email: String,
        val body: String
        )