package com.example.churchapp

import android.os.Build
import android.view.View
import android.widget.ImageView
import androidx.annotation.RequiresApi
import androidx.databinding.BindingAdapter
import com.example.churchapp.models.Sermon
import com.example.churchapp.repositories.SermonApiStatus
import java.time.LocalDate
import java.time.format.DateTimeFormatter

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


