package com.example.churchapp

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.example.churchapp.repositories.SermonApiStatus

@BindingAdapter("ApiStatus")
fun bindStatus(statusImageView: ImageView, status: SermonApiStatus?) {
    when(status) {
        SermonApiStatus.LOADING->{
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }
        SermonApiStatus.ERROR->{
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error)
        }
        SermonApiStatus.DONE->{
            statusImageView.visibility = View.GONE
        }
    }
}