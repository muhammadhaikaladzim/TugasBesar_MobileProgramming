package com.haikal.tugas_besar_mobile_programming

import android.app.Application
import com.haikal.tugas_besar_mobile_programming.core.di.networkModule
import com.haikal.tugas_besar_mobile_programming.core.di.repositoryModule1
import com.haikal.tugas_besar_mobile_programming.core.di.repositoryModule2
import com.haikal.tugas_besar_mobile_programming.di.useCaseModule
import com.haikal.tugas_besar_mobile_programming.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class BaseApplication: Application(){
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@BaseApplication)
            modules(
                networkModule,
                repositoryModule1,
                repositoryModule2,
                useCaseModule,
                viewModelModule

            )
        }
    }
}