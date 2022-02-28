package com.example.testapp.presenter

import com.example.testapp.view.ViewContract

internal interface PresenterContract {
    fun onAttach(view : ViewContract)
    fun onDetach()
}

