package app.donluconi.desafio_mobile2you

import app.donluconi.desafio_mobile2you.data.api.InterfaceAPI
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.verify


class InterfaceAPIUnitTest {

    //Testando se o método getMovieDetails é chamado (classe InterfaceAPI)
    @Test fun testMethodMovieDetails() {
        val methodTest = Mockito.mock(InterfaceAPI::class.java)
        methodTest.getMovieDetails()
        verify(methodTest).getMovieDetails()
    }

    //Testando se o método getSimilarMovies é chamado (classe InterfaceAPI)
    @Test fun testMethodSimilarMovie() {
        val methodTestSimilar = Mockito.mock(InterfaceAPI::class.java)
        methodTestSimilar.getSimilarMovies()
        verify(methodTestSimilar).getSimilarMovies()
    }
}


