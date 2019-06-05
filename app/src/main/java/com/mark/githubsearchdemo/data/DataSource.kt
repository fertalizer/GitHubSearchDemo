package com.mark.githubsearchdemo.data

import android.support.annotation.NonNull
import com.mark.githubsearchdemo.data.bean.GetUserList

interface DataSource {

    interface GetUserListCallback {

        fun onComplete(bean: GetUserList)

        fun onError(errorMessage: String)

    }

    fun getUserList(result: String, callback: GetUserListCallback )

}