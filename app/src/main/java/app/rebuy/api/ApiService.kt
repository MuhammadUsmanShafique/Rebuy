package app.rebuy.api

import app.rebuy.model.data.Memes
import retrofit2.http.GET

interface ApiService {
@GET ("get_memes")
suspend fun getMemes(): Memes



}