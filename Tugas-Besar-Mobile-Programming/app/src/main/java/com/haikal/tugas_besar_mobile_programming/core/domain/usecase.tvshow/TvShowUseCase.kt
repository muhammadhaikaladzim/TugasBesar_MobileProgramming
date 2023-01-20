package com.haikal.tugas_besar_mobile_programming.core.domain.usecase.tvshow

import com.haikal.tugas_besar_mobile_programming.core.data.remote.Resource
import com.haikal.tugas_besar_mobile_programming.core.domain.model.TvShow
import kotlinx.coroutines.flow.Flow

interface TvShowUseCase{
    fun getTvShow(): Flow<Resource<List<TvShow>>>
}