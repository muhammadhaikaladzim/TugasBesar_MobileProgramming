package com.haikal.tugas_besar_mobile_programming.core.domain.usecase.tvshow

import com.haikal.tugas_besar_mobile_programming.core.data.remote.Resource
import com.haikal.tugas_besar_mobile_programming.core.domain.model.Movie
import com.haikal.tugas_besar_mobile_programming.core.domain.model.TvShow
import com.haikal.tugas_besar_mobile_programming.core.domain.repository.ITvShowRepository
import kotlinx.coroutines.flow.Flow
import com.haikal.tugas_besar_mobile_programming.core.domain.usecase.tvshow.TvShowUseCase


class TvShowInteractor(private val repository: ITvShowRepository): TvShowUseCase {
    override fun getTvShow(): Flow<Resource<List<TvShow>>> = repository.getTvShow()
}