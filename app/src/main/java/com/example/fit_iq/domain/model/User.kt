package com.example.fit_iq.domain.model

data class User(
    val name:String,
    val email:String,
    val profilePictureUrl:String,
    val isAnonymous:Boolean,
    val userId:String? = null
)
