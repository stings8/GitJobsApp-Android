package com.example.gitjobs.data.network

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitClient {

        private const val GITJOBS_BASE_URL = "https://jobs.github.com/"

        val gitJobsApi = Retrofit.Builder()
            .baseUrl(GITJOBS_BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(GitJobsAPI::class.java)

}