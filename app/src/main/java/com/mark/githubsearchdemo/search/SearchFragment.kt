package com.mark.githubsearchdemo.search

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.mark.githubsearchdemo.R
import com.mark.githubsearchdemo.base.BaseView


class SearchFragment : Fragment(), SearchContract.View{
    private var mPresenter: SearchContract.Presenter ?= null
    private var mRecyclerView: RecyclerView ?= null
    private var mSearchAdapter: SearchAdapter ?= null

    companion object {
        @JvmStatic
        fun newInstance() =
            SearchFragment().apply {

            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mSearchAdapter = SearchAdapter(mPresenter!!)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var root = inflater.inflate(R.layout.fragment_search, container, false)
        mRecyclerView = root.findViewById(R.id.search_recycler)
        mRecyclerView?.layoutManager = LinearLayoutManager(context)
        mRecyclerView?.adapter = mSearchAdapter
        return root
    }


    override fun setPresenter(presenter: SearchContract.Presenter) {
        mPresenter = presenter
    }

    override fun initView() {

    }
}
