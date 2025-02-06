package app.rebuy.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {

    private val baseUrl = "https://api.imgflip.com"

    // Lazy initialization for Retrofit
    val retrofit: Retrofit by lazy {
        getRetrofitObject()
    }

    private fun getRetrofitObject(): Retrofit {
        // Create a logging interceptor
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()

        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    // Create the ApiService instance using Retrofit
    fun getApiService(): ApiService {
        return retrofit.create(ApiService::class.java)
    }
}
