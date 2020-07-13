package com.dhruvdroid.jetpack.userProfile

import retrofit2.Call
import retrofit2.http.GET

//
// Created by Dhruv Singh on 26/06/20.
//

interface Webservice {
    /**
     * @GET declares an HTTP GET request
     * @Path("user") annotation on the userId parameter marks it as a
     * replacement for the {user} placeholder in the @GET path
     */
    @GET("https://run.mocky.io/v3/5d74e3d8-5ba1-4a61-a162-8ddfaee41d05")
    fun getUser(userId: String): Call<User>

}