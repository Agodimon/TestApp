package com.example.testapp.presenter

import com.example.testapp.model.SearchResponse
import com.example.testapp.repository.RepositoryCallback
import io.reactivex.Observable

internal interface RepositoryContract {
    fun searchGithub(
        query: String,
        callback: RepositoryCallback
    )
    fun searchGithub(
        query: String
    ): Observable<SearchResponse>


}