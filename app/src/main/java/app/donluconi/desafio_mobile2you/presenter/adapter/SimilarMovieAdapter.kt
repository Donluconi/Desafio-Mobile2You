package app.donluconi.desafio_mobile2you.presenter.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import app.donluconi.desafio_mobile2you.R
import app.donluconi.desafio_mobile2you.domain.model.SimilarMovies
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_similar_movie.view.*


class SimilarMovieAdapter : RecyclerView.Adapter<SimilarMovieAdapter.MoviesViewHolder>() {

    private val urlBase = "https://image.tmdb.org/t/p/w500"

    //variável lista de filmes similares
    var list: MutableList<SimilarMovies> = mutableListOf()

    //verificando um valor
    set (value) {
        field = value
        //notifique qualquer observador registrado de que o conjunto de dados foi alterado
        notifyDataSetChanged()
    }

   // criando nossas visualizações da Lista de Filmes Similares.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_similar_movie, parent, false)
        return MoviesViewHolder(view)
    }

    // a exibição dos itens fica no onBind
    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.populate(list[position])
    }

    //ele retorna a quantidade de itens que serão exibidos
    override fun getItemCount() = list.size

    inner class MoviesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun populate(movieSimilar: SimilarMovies) {
            with(itemView) {

                //Picasso - para carregamento de imagens
                Picasso.get()
                    .load(urlBase + movieSimilar.backdrop_path)
                    .into(imgSimilarMovie)
                //exibindo as informações em seus respectivos campos
                txtTitleSimilar.text = movieSimilar.title
                txtDate.text = movieSimilar.release_date.substring(0 ,4)
                txtGenre.text = movieSimilar.genre_name

            }
        }
    }
}

