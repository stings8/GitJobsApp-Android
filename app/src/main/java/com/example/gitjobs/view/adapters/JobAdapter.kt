package com.example.gitjobs.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gitjobs.R
import com.example.gitjobs.data.model.Job

class JobAdapter(private val jobs: List<Job>, val onClickListener: (Job) -> Unit) :
    RecyclerView.Adapter<JobAdapter.JobView>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JobView =
        JobView(
            LayoutInflater.from(parent.context)
                .inflate(
                    R.layout.fragment_list,
                    parent,
                    false
                )

        )

    override fun getItemCount(): Int = jobs.size

    override fun onBindViewHolder(holder: JobAdapter.JobView, position: Int) =
        holder.bind(jobs[position])

    inner class JobView constructor(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        fun bind(job: Job) {
            with(itemView) {

                setOnClickListener {
                    onClickListener.invoke(job)
                }
            }
        }
    }
}

