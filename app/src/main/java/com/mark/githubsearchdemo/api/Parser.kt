package com.mark.githubsearchdemo.api

import com.mark.githubsearchdemo.data.User
import com.mark.githubsearchdemo.data.bean.GetUserList
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

class Parser {

    companion object {
        @JvmStatic
        fun parseError(jsonString: String ): JSONObject {

            var obj: JSONObject ?= null

            try {
                obj = JSONObject(jsonString)

            } catch (e: JSONException) {
                e.printStackTrace()
            }

            return obj!!
        }

        @JvmStatic
        fun parseGetUserList(jsonString: String ): GetUserList {

             var bean: GetUserList = GetUserList()

            try {
                var obj: JSONObject = parseError(jsonString)

                var items: JSONArray = obj.getJSONArray("items")

                for (i in 0 until items.length()) {
                    bean.getUsers().add(parseUser(items.getJSONObject(i)))
                }

            } catch (e: JSONException ) {
                e.printStackTrace()
            }

            return bean
        }

        @JvmStatic
        fun parseUser(jsonObject: JSONObject ): User {

            var objUser = User()

            try {
                objUser.setName(jsonObject.getString("login"))
            } catch (e: JSONException) {
                e.printStackTrace()
            }

            try {
                objUser.setAvatarUrl(jsonObject.getString("avatar_url"))
            } catch (e: JSONException ) {
                e.printStackTrace()
            }

            return objUser
        }

    }
}