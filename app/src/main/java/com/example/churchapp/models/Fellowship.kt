package com.example.churchapp.models

data class Fellowship(
 val id : Int,
 val day_id:String,
 val scripture:String,
 val description:String,
 val created_at:String,
 val updated_at:String?,
 val title:String
)