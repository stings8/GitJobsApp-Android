package com.example.gitjobs.data.network

import com.example.gitjobs.data.model.Job
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Part

interface GitJobsAPI {

    @GET("positions?description={description}")
    fun searchDescription(@Part("description") description: String): Observable<List<Job>>

}