package com.example.template.di

//import android.content.Context
//import com.bumptech.glide.Glide
//import com.bumptech.glide.load.engine.DiskCacheStrategy
//import com.bumptech.glide.request.RequestOptions
//import com.example.template.Utils.Constants.BASE_URL
//import com.example.template.R
//import dagger.Module
//import dagger.Provides
//import dagger.hilt.InstallIn
//import dagger.hilt.android.components.ApplicationComponent
//import dagger.hilt.android.qualifiers.ApplicationContext
//import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory
//import javax.inject.Singleton
//
///**
// * Created by Mehul Bisht on 19-12-2020
// */
//
//@Module
//@InstallIn(ApplicationComponent::class)
//object appModule {
//
//    @Singleton
//    @Provides
//    fun getRetrofitInstance(){
//        Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//    }
//
//    @Singleton
//    @Provides
//    fun getGlideInstance(
//        @ApplicationContext context : Context
//    ) = Glide.with(context).setDefaultRequestOptions(
//        RequestOptions()
//            .placeholder(R.drawable.ic_launcher_foreground)
//            .error(R.drawable.ic_launcher_foreground)
//            .diskCacheStrategy(DiskCacheStrategy.DATA)
//    )
//
//}