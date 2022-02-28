package com.example.testapp.view.search

import com.example.testapp.model.SearchResult
import com.example.testapp.view.ViewContract

internal interface ViewSearchContract : ViewContract {
    fun displaySearchResults(
        searchResults: List<SearchResult>,
        totalCount: Int
    )

    fun displayError()
    fun displayError(error: String)
    fun displayLoading(show: Boolean)
}
