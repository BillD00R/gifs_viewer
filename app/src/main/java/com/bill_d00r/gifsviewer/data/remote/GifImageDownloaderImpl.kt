package com.bill_d00r.gifsviewer.data.remote

import android.app.Application
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
        val outputFile = File(appContext.filesDir, fileName)
        withContext(Dispatchers.IO) {

            try {
                val responseBody = giphyApi.downloadImage(imageUrl)

                // Save the file to disk
                responseBody.byteStream().use { inputStream ->

                    FileOutputStream(outputFile).use { outputStream ->
                        inputStream.copyTo(outputStream)
                        outputStream.flush()
                        outputStream.close()
                    }
                }

//                outputFile = Glide
//                    .with(appContext)
//                    .downloadOnly()
//                    .load(imageUrl)
//                    .submit()
//                    .get()

                println("File downloaded successfully to ${outputFile.absolutePath} size:${outputFile.totalSpace}")
            }catch (e: Exception){
                e.printStackTrace()
            }

        }
        return outputFile.absolutePath
    }
}