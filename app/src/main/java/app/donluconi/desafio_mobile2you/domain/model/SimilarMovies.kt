package app.donluconi.desafio_mobile2you.domain.model


data class SimilarMovies (
    val id: Int,
    val title: String,
    val backdrop_path: String,
    val release_date: String,
    val genre_name: String,
    val results: List<SimilarMovies>
)

