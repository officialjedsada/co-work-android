package com.example.msigl62.coworkandroiduset.holder

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.msigl62.coworkandroiduset.extension.load
import com.example.msigl62.coworkandroiduset.model.modellistcowork.CoWorkPopular
import com.example.msigl62.coworkandroiduset.ui.detail.DetailPopularActivity
import kotlinx.android.synthetic.main.list_item_co_working_popular.view.*

class CoWorkPopularHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun onBind(coWork: CoWorkPopular) {
        itemView.apply {
            imageCoWorkPopular.load(coWork.gellery?.image_01)
            rating.numStars = coWork.rarting.toInt()
            rating.rating = coWork.rarting.toFloat()
            ratingTextPop.text = coWork.rarting
            textCoWorkPopularName.text = coWork.name
            imageCoWorkPopular.setOnClickListener {
                itemView.context.startActivity(Intent(itemView.context, DetailPopularActivity::class.java)
                        .putExtra(DetailPopularActivity.Key, coWork))
            }
//            favouritePop.setOnClickListener {
//                when (favouritePop.visibility == View. ) {
//                    true -> {show.text = "Hide"
//                        view.simpleFadeInAnimation() }
//                    else -> {show.text = "Show"
//                        view.simpleFadeOutAnimation() }
//                }
           // }

        }
    }
}