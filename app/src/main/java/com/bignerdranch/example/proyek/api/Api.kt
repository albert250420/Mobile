package com.bignerdranch.example.proyek.api

import com.bignerdranch.example.proyek.model.IndonesiaResponse
import com.bignerdranch.example.proyek.model.ProvinceResponse
import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("indonesia")
    fun getIndonesia(): Call<ArrayList<IndonesiaResponse>>

    @GET("indonesia/provinsi")
    fun getProvince(): Call<ArrayList<ProvinceResponse>>
}