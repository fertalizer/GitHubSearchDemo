package com.mark.githubsearchdemo.data

import android.os.AsyncTask
import com.mark.githubsearchdemo.data.bean.GetUserList

object RemoteDataSource : DataSource{

    override fun getUserList(result: String, callback: DataSource.GetUserListCallback) {
        var myTask: MyTask = MyTask(result, callback)
        myTask.execute()
    }
}