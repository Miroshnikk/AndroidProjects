package com.project10

import androidx.room.Database
import androidx.room.RoomDatabase
import com.project10.UserDao as UserDao

@Database(entities = [User::class], version = 1)
abstract class UserDB : RoomDatabase(){
    abstract fun userDao(): UserDao
}