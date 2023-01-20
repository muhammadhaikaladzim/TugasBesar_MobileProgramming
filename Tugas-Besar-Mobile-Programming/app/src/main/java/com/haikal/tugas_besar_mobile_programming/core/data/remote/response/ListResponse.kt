package com.haikal.tugas_besar_mobile_programming.core.data.remote.response

import com.google.gson.annotations.SerializedName

data class ListResponse<T>(
    @SerializedName("results")
    val results: List<T>
)
