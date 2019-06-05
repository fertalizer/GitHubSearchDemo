package com.mark.githubsearchdemo.data

class User {
    private var mName: String ?= null
    private var mAvatarUrl: String ?= null

    constructor() {
        mName = ""
        mAvatarUrl = ""
    }

    fun getName(): String{
        return mName!!
    }

    fun setName(name: String) {
        mName = name
    }

    fun getAvatarUrl(): String{
        return mAvatarUrl!!
    }

    fun setAvatarUrl(avatarUrl: String) {
        mAvatarUrl = avatarUrl
    }

}