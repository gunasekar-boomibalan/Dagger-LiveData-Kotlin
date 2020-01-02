package com.android.pbp.apa.di

import android.app.Application
import com.android.pbp.apa.ApaApplication
import com.android.pbp.apa.MainActivity
import dagger.Component
import dagger.Module
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
@Component(dependencies = [], modules = [RoomModule::class])
interface ApplicationComponent{
    fun Inject(application : ApaApplication)
    fun Inject(mainactivity : MainActivity)
}