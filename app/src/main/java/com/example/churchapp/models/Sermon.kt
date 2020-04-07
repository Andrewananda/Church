package com.example.churchapp.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Sermon(
    val id: Int,
    val title:String,
    val day_id: Int,
    val sermon_by: String,
    val description:String,
    val scripture: String,
    val remember_token:String,
    val created_at: String,
    val updated_at: String
): Parcelable