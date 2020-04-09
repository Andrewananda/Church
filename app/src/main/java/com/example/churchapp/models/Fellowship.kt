package com.example.churchapp.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Fellowship(
 val id : Int,
 val day_id:String,
 val title:String?,
 val scripture:String,
 val description:String,
 val created_at:String,
 val updated_at:String?,
 val day:String
):Parcelable