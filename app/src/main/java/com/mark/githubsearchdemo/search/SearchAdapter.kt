package com.mark.githubsearchdemo.search

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.mark.githubsearchdemo.R
import com.mark.githubsearchdemo.data.User
import com.squareup.picasso.Picasso
import java.util.ArrayList

class SearchAdapter : RecyclerView.Adapter<SearchAdapter.SearchViewHolder> {
    private var mPresenter: SearchContract.Presenter ?= null
    private var mUsers: ArrayList<User> = ArrayList()

    constructor(presenter: SearchContract.Presenter) {
        mPresenter = presenter
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): SearchViewHolder {
        return  SearchViewHolder(LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_search, viewGroup, false))
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        bindSearchViewHolder(holder, mUsers[position])
    }

    override fun getItemCount(): Int {
        return mUsers.size
    }

    private fun bindSearchViewHolder(holder: SearchViewHolder, user: User) {
        holder.mTextName.text = user.getName()
        Picasso.get()
            .load(user.getAvatarUrl())
            .fit()
            .centerCrop()
            .into(holder.mImageAvatar)
    }

    inner class SearchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var mTextName: TextView = itemView.findViewById(R.id.search_text_name)
        var mImageAvatar: ImageView = itemView.findViewById(R.id.search_image)
    }

    fun updateData(users: ArrayList<User>) {
        mUsers = users
        notifyDataSetChanged()
    }
}