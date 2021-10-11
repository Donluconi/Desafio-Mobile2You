package app.donluconi.desafio_mobile2you.data.api

import app.donluconi.desafio_mobile2you.domain.model.Movie
import app.donluconi.desafio_mobile2you.domain.model.SimilarMovies
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface InterfaceAPI {

    //Chave de acesso a API criada através do site do The Movie
    companion object {
        const val keyMovie = "8f13e30c6054fd3256fccc3f19e83aa7"
    }

    //GET - Recuperando os dados do servidor
    //Path - caminho
    @GET("movie/{movie_id}?api_key=$keyMovie")
    fun getMovieDetails(
    @Path("movie_id") movieId: Int = 27205 //27205 Filme A Origem
    ): Call<Movie>

    @GET("movie/{movie_id}/similar?api_key=$keyMovie")
    fun getSimilarMovies(
    @Path("movie_id") movieId: Int = 27205
    ): Call<SimilarMovies>

}