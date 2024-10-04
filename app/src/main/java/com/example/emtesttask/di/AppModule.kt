package com.example.emtesttask.di

import com.example.emtesttask.data.Api
import com.example.emtesttask.ui.search.SearchViewModel
import com.example.emtesttask.ui.todo.ToDoViewModel
import com.example.plantingapp.data.repository.Repository
import com.example.plantingapp.data.repository.RepositoryImpl
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {
    single<Repository> {
        val baseUrl = "https://drive.usercontent.google.com"
        val okHttpClient = OkHttpClient.Builder()
            .build()

        val api = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(Api::class.java)

        RepositoryImpl(api)
    }

    viewModel { SearchViewModel(get()) }
    viewModel { ToDoViewModel() }

}