package com.example.churchapp.models

data class Event(
    val id:Int,
    val title: String,
    val description:String,
    val date:String,
    val featured_photo:String,
    val remember_token:String,
    val created_at:String,
    val updated_at:String
)