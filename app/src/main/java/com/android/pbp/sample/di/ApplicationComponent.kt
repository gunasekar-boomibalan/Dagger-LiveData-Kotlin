package com.android.pbp.sample.di

import com.android.pbp.sample.AppClass
import com.android.pbp.sample.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(dependencies = [], modules = [RoomModule::class])
interface ApplicationComponent{
    fun Inject(application : AppClass)
    fun Inject(mainactivity : MainActivity)
}