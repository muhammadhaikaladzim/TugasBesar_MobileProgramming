package com.haikal.tugas_besar_mobile_programming.core.data.remote

import com.haikal.tugas_besar_mobile_programming.core.data.remote.network.ApiResponse
import com.haikal.tugas_besar_mobile_programming.core.data.remote.network.ApiService
import com.haikal.tugas_besar_mobile_programming.core.data.remote.response.TvShowResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow

class TvShowRemoteDataSource(private val apiService: ApiService) {

    suspend fun getTvShow(): Flow<ApiResponse<List<TvShowResponse>>> =
        channelFlow {
            try {
                val response = apiService.getTvShow()
                val data = response.results

                if (data.isNotEmpty()) send(ApiResponse.Success(data))
                else send(ApiResponse.Empty)

            }catch (e: Exception){
                e.printStackTrace()
                send(ApiResponse.Error(e.message.toString()))
            }
        }

}