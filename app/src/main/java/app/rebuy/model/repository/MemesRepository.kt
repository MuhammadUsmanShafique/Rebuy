package app.rebuy.model.repository

import app.rebuy.api.ApiService
import app.rebuy.api.RetrofitHelper
import app.rebuy.model.data.Memes
import javax.inject.Inject

class MemesRepository @Inject constructor() {

    // Using RetrofitHelper to get the ApiService instance
    private val apiService: ApiService = RetrofitHelper.getApiService()

    suspend fun fetchMemes(): Memes {
        return apiService.getMemes()
    }
}
