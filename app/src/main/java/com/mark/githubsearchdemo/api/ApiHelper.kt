package com.mark.githubsearchdemo.api

import com.mark.githubsearchdemo.data.bean.GetUserList
import java.io.IOException

class ApiHelper {

    companion object {
        private const val HOST: String = "https://api.github.com"
        private const val SEARCH_PATH: String = "/search"
        private const val USER_PATH: String = "/users"
        private const val REQUIRED_PATH: String = "?q="
        private const val GET_USERS_URL: String = HOST + SEARCH_PATH + USER_PATH + REQUIRED_PATH

        @JvmStatic
        @Throws(IOException::class)
        fun getUserList(result: String): GetUserList {
            return Parser.parseGetUserList(Client().get(GET_USERS_URL + result))
        }
    }
}