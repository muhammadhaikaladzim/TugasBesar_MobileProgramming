package com.haikal.tugas_besar_mobile_programming.core.domain.repository

import com.haikal.tugas_besar_mobile_programming.core.data.remote.Resource
import com.haikal.tugas_besar_mobile_programming.core.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface IMovieRepository {
    fun getMovies(): Flow<Resource<List<Movie>>>
}