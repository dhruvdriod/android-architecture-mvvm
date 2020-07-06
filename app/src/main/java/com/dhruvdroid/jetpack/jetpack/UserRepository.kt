package com.dhruvdroid.jetpack.jetpack

import androidx.lifecycle.LiveData
import java.util.concurrent.Executor
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Singleton

//
// Created by Dhruv Singh on 26/06/20.
//

/**
 * Repository modules handle data operations. They provide a clean API so that the rest of the app
 * can retrieve this data easily. They know where to get the data from and what API calls to make
 * when data is updated. You can consider repositories to be mediators between different data sources,
 * such as persistent models, web services, and caches.
 *
 * Important Purpose: it abstracts the data sources from the rest of the app. Now,
 * our UserProfileViewModel doesn't know how the data is fetched, so we can provide
 * the view model with data obtained from several different data-fetching implementations.
 *
 */
// Informs Dagger that this class should be constructed only once.
@Singleton
class UserRepository @Inject constructor(
    private val webservice: Webservice,
    // Simple in-memory cache. Details omitted for brevity.
    private val executor: Executor,
    private val userDao: UserDao
) {
    fun getUser(userId: String): LiveData<User> {
        refreshUser(userId)
        // Returns a LiveData object directly from the database.
        return userDao.load(userId)
    }

    private fun refreshUser(userId: String) {
        // Runs in a background thread.
        executor.execute {
            // Check if user data was fetched recently.
            val userExists = false
            /*userDao.hasUser(FRESH_TIMEOUT)*/
            if (!userExists) {
                // Refreshes the data.
                val response = webservice.getUser(userId).execute()

                // Check for errors here.

                // Updates the database. The LiveData object automatically
                // refreshes, so we don't need to do anything else here.
                userDao.save(response.body()!!)
            }
        }
    }

    companion object {
        val FRESH_TIMEOUT = TimeUnit.DAYS.toMillis(1)
    }
}