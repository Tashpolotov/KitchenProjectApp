package com.example.kitchenprojectapp.module

import android.app.Application
import android.content.Context
import com.example.kitchenprojectapp.repository.KitchenRepositoryMock
import com.example.data.room.KitchenDao
import com.example.domain.repository.KitchenRepository

import com.example.domain.usecase.KitchenUseCase
import com.example.kitchenprojectapp.room.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideContext(application: Application): Context {
        return application.applicationContext
    }


    @Provides
    @Singleton
    fun provideRepository(context: Context, kitchenDao: KitchenDao):KitchenRepository{
        return KitchenRepositoryMock(context, kitchenDao)
    }

    @Provides
    @Singleton
    fun provideUseCase(repository: KitchenRepository):KitchenUseCase{
        return KitchenUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideKitchenDatabase(@ApplicationContext context: Context):AppDatabase{
        return AppDatabase.getInstance(context)
    }

    @Provides
    fun provideKitchenDao(appDatabase: AppDatabase):KitchenDao{
        return appDatabase.getHomePopularDao()
    }
}