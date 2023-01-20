package com.haikal.tugas_besar_mobile_programming.ui.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.haikal.tugas_besar_mobile_programming.core.domain.usecase.movie.MovieUseCase

class MovieViewModel(private val useCase: MovieUseCase): ViewModel() {
    fun getMovies() = useCase.getMovies().asLiveData()
}