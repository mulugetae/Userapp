package com.mulugetaewnu.room

import androidx.annotation.WorkerThread

class UserRepository(private val userDao: UserDao){
    val allUser: List<User> = userDao.getAll()
    @Suppress("RedundantSuspedModifier")
    @WorkerThread
    suspend fun insert (user : User){
        userDao.insertAll(user)
    }
}