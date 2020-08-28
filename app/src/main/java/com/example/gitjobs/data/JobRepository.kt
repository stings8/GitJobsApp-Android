package com.example.gitjobs.data

import androidx.lifecycle.LiveData
import com.example.gitjobs.data.model.Job
import io.reactivex.Observable

interface JobRepository {
    fun listJobs(description: String): LiveData<List<Job>?>
}