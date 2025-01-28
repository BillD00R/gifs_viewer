package com.bill_d00r.gifsviewer.data.remote

import android.app.Application
import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File
import java.io.FileOutputStream
import javax.inject.Inject

class GifImageDownloaderImpl @Inject constructor(
    private val giphyApi: GiphyApi,
    private val appContext: Application
) : GifImageDownloader {
    override suspend fun downloadGifImage(imageUrl: String, fileName: String): String {

        val dir = File(appContext.filesDir.path + "/images_cache")
        if (!dir.exists()) dir.mkdir()

        val outputFile = File(dir, fileName)

        if (outputFile.exists()){
            Log.d("IMAGE_DOWNLOADER", "File exists: ${outputFile.absolutePath}")
            return outputFile.absolutePath
        }
        withContext(Dispatchers.IO) {

            try {
                val responseBody = giphyApi.downloadImage(imageUrl)

                responseBody.byteStream().use { inputStream ->
                    FileOutputStream(outputFile).use { outputStream ->
                        inputStream.copyTo(outputStream)
                        outputStream.flush()
                        outputStream.close()
                        inputStream.close()
                    }
                }
            }catch (e: Exception){
                e.printStackTrace()
            }
        }

        return outputFile.absolutePath
    }

    override suspend fun clearImageCache(){
        val dir = File(appContext.filesDir.path + "/images_cache")
        dir.delete()
    }

    override suspend fun deleteImages(paths: List<String>){
        paths.forEach { path ->
            val file = File(path)
            file.delete()
        }
    }

//    override suspend fun cleanImageCache(actualFiles : List<String>){
//        val dir = File(appContext.filesDir.path + "/images_cache")
//        val files = dir.listFiles()
//        for (file in files!!){
//            if (file.absolutePath !in actualFiles)
//                file.delete()
//        }
//    }
}