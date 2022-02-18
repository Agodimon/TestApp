package com.example.testapp.presenter.search

import com.example.testapp.presenter.PresenterContract

internal interface PresenterSearchContract : PresenterContract {
    fun searchGitHub(searchQuery: String)

}
