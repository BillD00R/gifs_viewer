package com.bill_d00r.gifsviewer.di

import android.content.Context
import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.room.Room
import com.bill_d00r.gifsviewer.data.local.GifDatabase
import com.bill_d00r.gifsviewer.data.local.GifEntity
import com.bill_d00r.gifsviewer.data.remote.GifImageDownloader
import com.bill_d00r.gifsviewer.data.remote.GifImageDownloaderImpl
import com.bill_d00r.gifsviewer.data.remote.GiphyApi
import com.bill_d00r.gifsviewer.data.remote.GiphyRemoteMediator
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.internal.Contexts.getApplication
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@OptIn(ExperimentalPagingApi::class)
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideGifDatabase(@ApplicationContext context: Context): GifDatabase {
        return Room.databaseBuilder(
            context,
            GifDatabase::class.java,
            "gifs.db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideGiphyApi(): GiphyApi {
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
        return Retrofit.Builder()
            .baseUrl(GiphyApi.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create()
    }

    @Provides
    @Singleton
    fun provideGifPager(gifDb: GifDatabase, giphyApi: GiphyApi, gifImageDownloader: GifImageDownloader): Pager<Int, GifEntity> {
        return Pager(
            config = PagingConfig(pageSize = 4),
            remoteMediator = GiphyRemoteMediator(
                gifDatabase = gifDb,
                giphyApi = giphyApi,
                gifImageDownloader = gifImageDownloader
            ),
            pagingSourceFactory = {
                gifDb.dao.pagingSource()
            }
        )
    }

    @Provides
    @Singleton
    fun provideGifImageDownloader(@ApplicationContext context: Context, giphyApi: GiphyApi): GifImageDownloader{
        return GifImageDownloaderImpl(
            giphyApi = giphyApi,
            appContext = getApplication(context)
        )
    }

}