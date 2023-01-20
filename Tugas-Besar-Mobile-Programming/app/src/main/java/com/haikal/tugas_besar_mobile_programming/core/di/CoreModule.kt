package com.haikal.tugas_besar_mobile_programming.core.di

import androidx.viewbinding.BuildConfig
import com.haikal.tugas_besar_mobile_programming.core.data.remote.MovieRemoteDataSource
import com.haikal.tugas_besar_mobile_programming.core.data.remote.TvShowRemoteDataSource
import com.haikal.tugas_besar_mobile_programming.core.data.remote.network.ApiService
import com.haikal.tugas_besar_mobile_programming.core.data.repository.MovieRepository
import com.haikal.tugas_besar_mobile_programming.core.data.repository.TvShowRepository
import com.haikal.tugas_besar_mobile_programming.core.domain.repository.IMovieRepository
import com.haikal.tugas_besar_mobile_programming.core.domain.repository.ITvShowRepository
import com.haikal.tugas_besar_mobile_programming.utils.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {

    single {
        val httpCliet = OkHttpClient.Builder()

        if (BuildConfig.DEBUG) {
            val logging = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
            httpCliet.addInterceptor(logging)
        }

        httpCliet
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .build()
    }

    single {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
            .create(ApiService::class.java)
    }

}

val repositoryModule1 = module {
    single { MovieRemoteDataSource(get()) }
    single<IMovieRepository> { MovieRepository(get()) }



}

val repositoryModule2 = module {

    single { TvShowRemoteDataSource(get()) }
    single<ITvShowRepository> { TvShowRepository(get()) }


}


