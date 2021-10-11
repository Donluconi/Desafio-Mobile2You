package app.donluconi.desafio_mobile2you

import android.app.Application
import app.donluconi.desafio_mobile2you.presenter.dependency.DependencyInjection
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


class KoinApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        //Classe para iniciar o Koin (ferramenta para injeção de dependência)
        startKoin {
            androidContext(this@KoinApplication)
            modules(DependencyInjection.di) //referência ao AppModule
        }
    }
    }


