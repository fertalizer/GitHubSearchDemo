package com.mark.githubsearchdemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.mark.githubsearchdemo.search.SearchFragment
import com.mark.githubsearchdemo.search.SearchPresenter

class MainActivity : AppCompatActivity() {
    private var mPresenter: SearchPresenter ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        searchDemo()
    }

    private fun searchDemo() {
        var fragmentTransaction = getSupportFragmentManager().beginTransaction()
        var fragment = SearchFragment.newInstance()
        mPresenter = SearchPresenter(fragment)
        fragmentTransaction.replace(R.id.container, fragment, Constant.FRAGMENT_SEARCH)
        fragmentTransaction.commit()
    }
}
