package com.haikal.tugas_besar_mobile_programming.utils

import android.content.Context
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.haikal.tugas_besar_mobile_programming.R

const val API_KEY = "907d0a4b623df45f0ae9cea46720323d"
const val BASE_URL = "https://api.themoviedb.org/3/"

const val BASE_URL_API_IMAGE = "https://image.tmdb.org/t/p/"
const val POSTER_SIZE_W185 = "w185"
const val POSTER_SIZE_W780 = "w780"

fun ImageView.loadImageMovie(url: Any?){
    Glide.with(this.context)
        .load(url)
        .apply(RequestOptions.placeholderOf(R.drawable.ic_loading_movie))
        .into(this)
}

fun ImageView.loadImageTvShow(url: Any?){
    Glide.with(this.context)
        .load(url)
        .apply(RequestOptions.placeholderOf(R.drawable.ic_loading_tvshow))
        .into(this)
}

fun Context.showToast(message: String){
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}