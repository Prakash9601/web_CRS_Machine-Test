
package com.softland.machinetest.di



import android.content.Context
import android.content.SharedPreferences
import com.softland.machinetest.api.MachineTestRetrofit
import com.softland.machinetest.model.ProductDao
import com.softland.machinetest.utils.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideSharedPreferences(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
    }

    @Singleton
    @Provides
    fun provideUnsplashService(): MachineTestRetrofit {
        return MachineTestRetrofit.create()
    }

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return AppDatabase.getInstance(context)
    }
    @Provides
    fun provideLocationDao(appDatabase: AppDatabase): ProductDao? {
        return appDatabase.ProductDao()
    }
}
