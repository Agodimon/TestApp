package com.example.testapp

import com.example.testapp.presenter.details.DetailsPresenter
import com.example.testapp.view.details.ViewDetailsContract
import com.nhaarman.mockito_kotlin.atLeastOnce
import com.nhaarman.mockito_kotlin.verify
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations


class DetailsPresenterTest {
    private lateinit var presenter: DetailsPresenter

    @Mock
    private lateinit var viewContract: ViewDetailsContract




    @Before
    fun setUp() {
        //Обязательно для аннотаций "@Mock"
        //Раньше было @RunWith(MockitoJUnitRunner.class) в аннотации к самому классу (SearchPresenterTest)
        MockitoAnnotations.openMocks(this)
        //Создаем Презентер, используя моки Репозитория и Вью, проинициализированные строкой выше
        presenter = DetailsPresenter(viewContract)

    }


    @Test
    fun onIncrementPresenterTest() {
        presenter.onIncrement()
        verify(viewContract, atLeastOnce()).setCount(1)
    }

    @Test
    fun onDecrementPresenterTest() {
        presenter.onDecrement()
        verify(viewContract, atLeastOnce()).setCount(-1)
    }


    @Test
    fun attachView_PresenterTest() {
//        presenter.onAttach(viewContract)
        val instance = presenter.javaClass
        instance.declaredFields.forEach {
            it.isAccessible = true
            if (it.name == "view") {
                Assert.assertEquals(viewContract, it.get(presenter))
            }
        }
    }

    @Test
    fun detachView_Presenter_Test() {
//        presenter.onDetach()
        val instance = presenter.javaClass
        instance.declaredFields.forEach {
            it.isAccessible = true
            if (it.name == "view"){
                Assert.assertNull(it.get(presenter))
            }
        }
    }

}
