package com.mark.githubsearchdemo.search

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mark.githubsearchdemo.R
import java.util.ArrayList

class SearchAdapter : RecyclerView.Adapter<SearchAdapter.SearchViewHolder> {
    private var mPresenter: SearchContract.Presenter ?= null

    constructor(presenter: SearchContract.Presenter) {
        mPresenter = presenter
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): SearchViewHolder {
        return  SearchViewHolder(LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_search, viewGroup, false))
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 20
    }

    inner class SearchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){


    }

    fun updateData() {

    }
}