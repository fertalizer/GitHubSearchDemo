package com.mark.githubsearchdemo.data

import android.os.AsyncTask
import android.util.Log
import com.mark.githubsearchdemo.Constant
import com.mark.githubsearchdemo.api.ApiHelper
import com.mark.githubsearchdemo.data.bean.GetUserList
import java.io.IOException

class MyTask : AsyncTask<Void, Void, GetUserList> {
    private var mErrorMessage = ""
    private var mResult: String ?= null
    private var mCallback: DataSource.GetUserListCallback ?= null


    constructor(result: String, callback: DataSource.GetUserListCallback) {
        mResult = result
        mCallback = callback
    }

    override fun onPreExecute() {
        super.onPreExecute()
    }

    override fun doInBackground(vararg params: Void?): GetUserList {
        var bean: GetUserList ?= null
        try {
            bean = ApiHelper.getUserList(mResult!!)
        } catch (e: IOException) {
            mErrorMessage = e.message!!
            e.printStackTrace()
        }
        return bean!!

    }

    override fun onPostExecute(bean: GetUserList?) {

        if (bean != null) {

            mCallback?.onComplete(bean)
        } else if ("" != mErrorMessage) {

            mCallback?.onError(mErrorMessage)
        } else {

            Log.d(Constant.TAG, "GetUserList fail");
        }

    }
}