package app.donluconi.desafio_mobile2you.data

import app.donluconi.desafio_mobile2you.data.service.Retrofit
import app.donluconi.desafio_mobile2you.domain.model.Movie
import app.donluconi.desafio_mobile2you.domain.model.SimilarMovies
import retrofit2.Callback


class MovieRepository(private val retrofit: Retrofit) {

    //chamada dos filmes
    fun getMovieDetails(callback: Callback<Movie>) {
        val retroApi = retrofit.retroApi()
        val call =  retroApi.getMovieDetails()
        call.enqueue(callback)
    }

    //chamada dos filmes similares
    fun getSimilarMovies(callback: Callback<SimilarMovies>) {
        val retroApi = retrofit.retroApi()
        val call =  retroApi.getSimilarMovies()
        call.enqueue(callback)
    }

}
