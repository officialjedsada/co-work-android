package com.example.msigl62.coworkandroiduset.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.msi_gl62.co_work_android_uset.R
import com.example.msigl62.coworkandroiduset.holder.CoWorkPopularHolder
import com.example.msigl62.coworkandroiduset.model.modellistcowork.CoWorkPopular

class AdapterCoWorkPopular(private var coWork: List<CoWorkPopular>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    fun setItem(items: List<CoWorkPopular>) {
        coWork = items
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
            CoWorkPopularHolder(LayoutInflater.from(parent.context).inflate(viewType, parent, false))

    override fun getItemCount(): Int = coWork.size

    override fun getItemViewType(position: Int): Int = R.layout.list_item_co_working_popular

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) =
            (holder as CoWorkPopularHolder).onBind(coWork[position])
}