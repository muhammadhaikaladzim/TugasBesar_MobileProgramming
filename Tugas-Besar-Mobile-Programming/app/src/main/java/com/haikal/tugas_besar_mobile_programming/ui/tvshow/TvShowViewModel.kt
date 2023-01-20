package com.haikal.tugas_besar_mobile_programming.ui.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.haikal.tugas_besar_mobile_programming.core.domain.usecase.tvshow.TvShowUseCase

class TvShowViewModel(private val useCase: TvShowUseCase): ViewModel() {

    fun getTvShow() = useCase.getTvShow().asLiveData()
}