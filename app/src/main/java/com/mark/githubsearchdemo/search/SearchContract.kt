package com.mark.githubsearchdemo.search

import com.mark.githubsearchdemo.base.BasePresenter
import com.mark.githubsearchdemo.base.BaseView

interface SearchContract {

    interface View : BaseView<Presenter> {

        fun initView()

    }


    interface Presenter : BasePresenter {

    }
}