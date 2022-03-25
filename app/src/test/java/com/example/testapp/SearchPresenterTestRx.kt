package com.example.testapp

import com.example.testapp.presenter.search.ScheduleProviderStub
import com.example.testapp.presenter.search.SearchPresenter
import com.example.testapp.repository.GitHubRepository
import com.example.testapp.view.search.ViewSearchContract
import org.junit.Before
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class SearchPresenterTestRx {
    private lateinit var presenter: SearchPresenter
    @Mock
    private lateinit var repository: GitHubRepository
    @Mock
    private lateinit var viewContract: ViewSearchContract
    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = SearchPresenter(viewContract, repository, ScheduleProviderStub())
    }
    companion object {
        private const val SEARCH_QUERY = "some query"
        private const val ERROR_TEXT = "error"
    }
}