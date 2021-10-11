package app.donluconi.desafio_mobile2you.presenter.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import app.donluconi.desafio_mobile2you.R
import app.donluconi.desafio_mobile2you.data.service.Retrofit.*
import app.donluconi.desafio_mobile2you.domain.model.Movie
import app.donluconi.desafio_mobile2you.domain.model.SimilarMovies
import app.donluconi.desafio_mobile2you.presenter.adapter.SimilarMovieAdapter
import app.donluconi.desafio_mobile2you.presenter.model.MovieViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {

    //declaração de variáveis
    private val viewModel: MovieViewModel by viewModel()
    private lateinit var adapter: SimilarMovieAdapter
    private val urlBase = "https://image.tmdb.org/t/p/w500"
    private var isFavorite = true


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        adapter = SimilarMovieAdapter()
        recyclerViewMovie.adapter = adapter
        getMovieDetails()
        movieFavorite()

    }

        //obter filmes
        private fun getMovieDetails() {

        //chamamos a injeção de dependência viewModel para fazer o getMovieDetails
        viewModel.getMovieDetails(object : Callback<Movie> {

        //resposta
        override fun onResponse(callMovie: Call<Movie>, responseMovie: Response<Movie>) {
            val movie = responseMovie.body()
            displayMovie(movie) //método para a exibição do filme
        }
        //em caso de falha (Throwable pega também exceções derivadas de Error)
        override fun onFailure(call: Call<Movie>, t: Throwable) {
            Toast.makeText(this@MainActivity, "Tente novamente mais tarde!",Toast.LENGTH_SHORT).show()
        }

        })


        //Filmes similares
        viewModel.getSimilarMovies(object : Callback<SimilarMovies> {

            //chamada para preencher a lista de filmes similares
            override fun onResponse(callSimilar: Call<SimilarMovies>, responseSimilar: Response<SimilarMovies>) {
                    val similarMovie = responseSimilar.body()
                    adapter.list = similarMovie?.results?.toMutableList() ?: mutableListOf() //Lista Mutável
            }
            //em caso de falha (Throwable pega também exceções derivadas de Error)
            override fun onFailure(callSimilar: Call<SimilarMovies>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Tente novamente mais tarde!",Toast.LENGTH_SHORT).show()
            }
            })

        }

        //exibir filme
        private fun displayMovie(movie: Movie?) {

            //exibir a quantidade de visualizações e curtidas junto com a imagem.
            if (movie != null) {
                Picasso.get().load(urlBase + "${movie.poster_path}")
                    .into(imgMovie)
                txtTitleMovie.text = movie?.title
                txtLikes.text = "${movie.vote_count} " + getString(R.string.qtdLikes)
                txtViews.text = "${movie.popularity} " + getString(R.string.qtdViews)
            }
            else {
                //exibição de imagem de indisponibilidade em caso de falha.
                imgMovie.setImageResource(R.drawable.ic_unavailable)
            }

        }


        //Ações do botão de favoritar (Heart)
        private fun movieFavorite() {

            imgFavorite.setOnClickListener { isClicked ->

                //atribuindo True ou False no isFavorite.
                   isFavorite = if (isFavorite) {
                        imgFavorite.setImageResource(R.drawable.ic_favorite_empty)
                        false
                    } else {
                        imgFavorite.setImageResource(R.drawable.ic_favorite)
                        true
                    }
                }
            }
        }



