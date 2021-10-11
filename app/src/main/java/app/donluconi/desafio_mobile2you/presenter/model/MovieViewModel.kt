package app.donluconi.desafio_mobile2you.presenter.model

import androidx.lifecycle.ViewModel
import app.donluconi.desafio_mobile2you.data.MovieRepository
import app.donluconi.desafio_mobile2you.domain.model.Movie
import app.donluconi.desafio_mobile2you.domain.model.SimilarMovies
import retrofit2.Callback

//receber via injeção de dependencia nosso repósitorio

class MovieViewModel(private val movieRepository: MovieRepository): ViewModel() {

    /*função getMovie (Filmes) para obter a lista de filmes
    callback que retorna através do retrofit.*/

    fun getMovieDetails(callback: Callback<Movie>) = movieRepository.getMovieDetails(callback = callback)
    fun getSimilarMovies(callback: Callback<SimilarMovies>) = movieRepository.getSimilarMovies(callback = callback)

}