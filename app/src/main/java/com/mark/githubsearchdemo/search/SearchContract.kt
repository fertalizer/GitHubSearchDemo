package com.mark.githubsearchdemo.search

import com.mark.githubsearchdemo.base.BasePresenter
import com.mark.githubsearchdemo.base.BaseView
import com.mark.githubsearchdemo.data.bean.GetUserList

interface SearchContract {

    interface View : BaseView<Presenter> {

        fun initView()

        fun showSearchUi(bean: GetUserList)

    }


    interface Presenter : BasePresenter {

        fun loadSearchData(result: String )

        fun setSearchData(bean: GetUserList)

    }
}