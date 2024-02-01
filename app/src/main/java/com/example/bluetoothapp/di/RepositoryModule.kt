package com.example.bluetoothapp.di

import com.example.bluetoothapp.network.retrofit.RetrofitCosmo
import com.example.bluetoothapp.repository.CosmoRepository
import com.example.bluetoothapp.repository.DefaultCosmoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideCosmoRepository(retrofitCosmo: RetrofitCosmo): CosmoRepository {
        return DefaultCosmoRepository(retrofitCosmo)
    }
}