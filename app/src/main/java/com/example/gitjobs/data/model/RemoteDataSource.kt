package com.example.gitjobs.data.model

import com.example.gitjobs.data.network.RetrofitClient
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class RemoteDataSource {

    fun listJobs(description: String): Observable<List<Job>> = RetrofitClient.gitJobsApi
        .searchDescription(description)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
}