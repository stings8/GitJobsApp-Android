package com.example.gitjobs.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.gitjobs.data.model.Job
import com.example.gitjobs.data.model.RemoteDataSource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

class JobRepositoryImpl: JobRepository {

    private val remoteDataSource = RemoteDataSource()
    private val compositeDisposable = CompositeDisposable()

    override fun listJobs(description: String): LiveData<List<Job>?> {
        val data = MutableLiveData<List<Job>?>()

        val disposable = remoteDataSource.listJobs(description)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableObserver<List<Job>>() {
                override fun onComplete() {
                    println("Complete")
                }

                override fun onNext(t: List<Job>) {
                    data.postValue(t)
                }

                override fun onError(e: Throwable) {
                    e.printStackTrace()
                    data.postValue(null)
                }
            })
        compositeDisposable.add(disposable)
        return data
    }
}