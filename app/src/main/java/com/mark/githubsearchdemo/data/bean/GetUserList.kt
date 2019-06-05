package com.mark.githubsearchdemo.data.bean

import com.mark.githubsearchdemo.data.User

class GetUserList {
    private var mUsers: ArrayList<User> ?= null

    constructor() {
        mUsers = ArrayList()
    }

    fun getUsers(): ArrayList<User> {
        return mUsers!!
    }
}