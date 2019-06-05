package com.mark.githubsearchdemo.search

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText

import com.mark.githubsearchdemo.R
import com.mark.githubsearchdemo.base.BaseView
import com.mark.githubsearchdemo.data.bean.GetUserList


class SearchFragment : Fragment(), SearchContract.View, View.OnClickListener {
    private var mPresenter: SearchContract.Presenter ?= null
    private var mRecyclerView: RecyclerView ?= null
    private var mSearchAdapter: SearchAdapter ?= null
    private var mEditText: EditText ?= null
    private var mButton: Button ?= null
    private var mResult: String ?= null

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
        mEditText = root.findViewById(R.id.search_edit_name)
        mButton = root.findViewById(R.id.search_button)
        mRecyclerView?.layoutManager = LinearLayoutManager(context)
        mRecyclerView?.adapter = mSearchAdapter
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mEditText?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable) {
                mResult = s.toString()
            }
        })

        mButton?.setOnClickListener(this)
    }

    override fun setPresenter(presenter: SearchContract.Presenter) {
        mPresenter = presenter
    }

    override fun initView() {

    }

    override fun showSearchUi(bean: GetUserList) {
        mSearchAdapter?.updateData(bean.getUsers())
    }

    override fun onClick(v: View?) {
        if ("" != mResult && mResult != null) {
            mRecyclerView?.visibility = View.VISIBLE
            mPresenter?.loadSearchData(mResult!!)
        } else {
            mRecyclerView?.visibility = View.GONE
        }
    }
}
