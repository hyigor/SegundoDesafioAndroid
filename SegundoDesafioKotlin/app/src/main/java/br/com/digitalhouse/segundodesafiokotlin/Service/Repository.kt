package br.com.digitalhouse.segundodesafiokotlin.Service
import android.app.Service
import br.com.digitalhouse.segundodesafiokotlin.Entities.Resposta
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface Repository{

    @GET("comics")
    suspend fun getResults(
            @Query("offset")n0: Int,
            @Query("ts")n1: String,
            @Query("apikey")n2: String,
            @Query("hash")n3: String,
            @Query("titleStartsWith")n4: String,
            @Query("noVariants")n5: Boolean
    ) : Resposta

}

val urlApiMarvel = "https://gateway.marvel.com/v1/public/"


val retrofit = Retrofit.Builder()
        .baseUrl(urlApiMarvel)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

val service: Repository = retrofit.create(Repository::class.java)