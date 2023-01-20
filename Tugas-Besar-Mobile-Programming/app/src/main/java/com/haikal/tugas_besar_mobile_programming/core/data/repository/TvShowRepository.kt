package com.haikal.tugas_besar_mobile_programming.core.data.repository

import com.haikal.tugas_besar_mobile_programming.core.data.remote.Resource
import com.haikal.tugas_besar_mobile_programming.core.data.remote.TvShowRemoteDataSource
import com.haikal.tugas_besar_mobile_programming.core.data.remote.network.ApiResponse
import com.haikal.tugas_besar_mobile_programming.core.domain.model.TvShow
import com.haikal.tugas_besar_mobile_programming.core.domain.repository.ITvShowRepository
import com.haikal.tugas_besar_mobile_programming.core.utils.mapTvShowResponseToDomain
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow

class TvShowRepository(private val tvShowRemoteDataSource: TvShowRemoteDataSource): ITvShowRepository {
    override fun getTvShow(): Flow<Resource<List<TvShow>>> =
        flow {
            emit(Resource.Loading())
            when(val apiResponse = tvShowRemoteDataSource.getTvShow().first()){
                is ApiResponse.Success -> emit(Resource.Success(apiResponse.data.map { mapTvShowResponseToDomain(it) }))
                is ApiResponse.Empty -> emit(Resource.Success(null))
                is ApiResponse.Error -> emit(Resource.Error(apiResponse.errorMessage))
            }
        }

}