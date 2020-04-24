package com.example.churchapp

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.example.churchapp.repositories.ApiStatus
import com.example.churchapp.repositories.EventApiStatus
import com.example.churchapp.repositories.FellowshipApiStatus

@BindingAdapter("ApiStatus")
fun bindStatus(statusImageView: ImageView, status: ApiStatus?) {
    when(status) {
        ApiStatus.LOADING->{
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }
        ApiStatus.ERROR->{
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error)
        }
        ApiStatus.DONE->{
            statusImageView.visibility = View.GONE
        }
    }
}

@BindingAdapter("EventApiStatus")
fun bindEventsStatus(statusImageView: ImageView, status: EventApiStatus?) {
    when(status) {
        EventApiStatus.ELOADING ->{
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }
        EventApiStatus.EERROR ->{
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error)
        }
        EventApiStatus.EDONE ->{
            statusImageView.visibility = View.GONE
        }
    }
}

@BindingAdapter("FellowshipApiStatus")
fun bindFellowshipStatus(statusImageView: ImageView, status: FellowshipApiStatus?) {
    when(status) {
        FellowshipApiStatus.FLOADING ->{
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }
        FellowshipApiStatus.FERROR ->{
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error)
        }
        FellowshipApiStatus.FDONE ->{
            statusImageView.visibility = View.GONE
        }
    }
}

