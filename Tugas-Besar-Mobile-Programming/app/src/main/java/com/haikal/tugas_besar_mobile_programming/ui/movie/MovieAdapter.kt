package com.haikal.tugas_besar_mobile_programming.ui.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.haikal.tugas_besar_mobile_programming.core.domain.model.Movie
import com.haikal.tugas_besar_mobile_programming.databinding.ItemMovieOrTvshowBinding
import com.haikal.tugas_besar_mobile_programming.utils.BASE_URL_API_IMAGE
import com.haikal.tugas_besar_mobile_programming.utils.DivMovieCallback
import com.haikal.tugas_besar_mobile_programming.utils.POSTER_SIZE_W185
import com.haikal.tugas_besar_mobile_programming.utils.loadImageMovie

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    private var listener: ((Movie) -> Unit)? = null

    var movies = mutableListOf<Movie>()
        set(value) {
            val callback = DivMovieCallback(field, value)
            val result = DiffUtil.calculateDiff(callback)
            field.clear()
            field.addAll(value)
            result.dispatchUpdatesTo(this)
        }

    inner class ViewHolder(private val binding: ItemMovieOrTvshowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Movie) {
            binding.apply {
                movie.poster?.let {
                    poster.loadImageMovie("$BASE_URL_API_IMAGE$POSTER_SIZE_W185$it")
                }
                tvTitle.text = movie.name
                tvDesc.text = if (movie.desc?.isNotBlank() as Boolean) movie.desc else "No Description"

                listener?.let { itemView.setOnClickListener { it(movie) } }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemMovieOrTvshowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    override fun getItemCount(): Int = movies.size

    fun onClick(listener: ((Movie) -> Unit)?){
        this.listener = listener
    }
}