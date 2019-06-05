package com.mark.githubsearchdemo.search

class SearchPresenter : SearchContract.Presenter{
    private var mView: SearchContract.View ?= null

    constructor(view: SearchContract.View) {
        mView = view
        mView?.setPresenter(this)
    }

    override fun start() {
       mView?.initView()
    }
}