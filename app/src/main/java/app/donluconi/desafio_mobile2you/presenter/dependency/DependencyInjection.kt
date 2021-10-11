package app.donluconi.desafio_mobile2you.presenter.dependency

import app.donluconi.desafio_mobile2you.data.MovieRepository
import app.donluconi.desafio_mobile2you.data.service.Retrofit
import app.donluconi.desafio_mobile2you.presenter.model.MovieViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module


//injeção de dependência - reutilização de objetos nos projetos
object DependencyInjection {

    val di = module {

        viewModel { MovieViewModel( get() ) }

        // tipo de escopo que persistirá pelo tempo de vida do app.
        single { Retrofit() }

        //factory fornece uma nova instância da dependência solicitada sempre que ela precisar ser injetada
        factory { MovieRepository( get() ) }

    }

}