package com.example.moviesdbfilm.support

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.moviesdbfilm.R

@BindingAdapter("imgUrl")
fun imgUrl(imgView: ImageView, url: String?){
    url?.let {
        Glide.with(imgView.context)
            .load(it)
            .apply(
                RequestOptions().placeholder(R.drawable.loading_animation)
                .error(R.drawable.ic_broken_image))
            .into(imgView)
    }
}

@BindingAdapter("overview")
fun overview(textView: TextView, overview: String?){
    overview?.let {
        textView.text = overview
    }
}

@BindingAdapter("voteAverage")
fun voteAverage(textView: TextView, voteAverage: String?){
    voteAverage?.let {
        textView.text = voteAverage
    }
}

@BindingAdapter("characterName")
fun charName(textView: TextView, characterName: String?){
    characterName?.let {
        textView.text = characterName
    }
}