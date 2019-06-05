package com.mark.githubsearchdemo.search

import android.os.AsyncTask
import android.util.Log
import com.mark.githubsearchdemo.data.DataSource
import com.mark.githubsearchdemo.data.RemoteDataSource
import com.mark.githubsearchdemo.data.bean.GetUserList

class SearchPresenter : SearchContract.Presenter{
    private var mView: SearchContract.View ?= null
    private var mRemoteDataSource: RemoteDataSource ?= null

    constructor(remoteDataSource: RemoteDataSource, view: SearchContract.View) {
        mRemoteDataSource = remoteDataSource
        mView = view
        mView?.setPresenter(this)
    }

    override fun start() {
       mView?.initView()
    }

    override fun loadSearchData(result: String) {
        mRemoteDataSource?.getUserList(result, object : DataSource.GetUserListCallback {
            override fun onComplete(bean: GetUserList) {
                Log.d("Mark", "Complete")
                setSearchData(bean)
            }

            override fun onError(errorMessage: String) {

            }
        })
    }

    override fun setSearchData(bean: GetUserList) {
        mView?.showSearchUi(bean)
    }
}