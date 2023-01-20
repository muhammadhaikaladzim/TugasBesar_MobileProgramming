package com.haikal.tugas_besar_mobile_programming.core.data.remote.network

sealed class ApiResponse<out R>{
    data class Success<out T>(val data: T): ApiResponse<T>()
    data class Error(val errorMessage: String): ApiResponse<Nothing>()
    object Empty: ApiResponse<Nothing>()
}
