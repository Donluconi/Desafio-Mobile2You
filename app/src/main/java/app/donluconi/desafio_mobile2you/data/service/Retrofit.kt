package app.donluconi.desafio_mobile2you.data.service

import app.donluconi.desafio_mobile2you.data.api.InterfaceAPI
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Retrofit {

    companion object {
        const val BASE_URL = "https://api.themoviedb.org/3/"
    }

    //inicializando o Retrofit
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL) //url da API
        .addConverterFactory(GsonConverterFactory.create()) //conversor de objetos Gson
        .build() //construindo o objeto

        //criando uma função que devolve instancia da InterfaceAPI
        fun retroApi(): InterfaceAPI = retrofit.create(InterfaceAPI::class.java)

    }
