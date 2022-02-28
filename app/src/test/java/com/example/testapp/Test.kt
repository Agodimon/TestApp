package com.example.testapp

import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations

class Test {

    @Mock
    private lateinit var multiply: Real


    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
//        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun mock1() {
        `when`(multiply.execute(2, 3)).thenReturn(4)
        `when`(multiply.execute(anyInt(), eq(3))).thenReturn(1)
        `when`(multiply.execute(2, 30)).thenReturn(40)
        `when`(multiply.execute(2, 4))
            .thenCallRealMethod()

        assert(multiply.execute(2, 4) == 8)
        verify(multiply, times(1)).execute(3,4)
        println("123123")
    }
}

interface Multiply {
    fun execute(a: Int, b: Int): Int
}

class Real : Multiply {
    override fun execute(a: Int, b: Int): Int {
        return a * b
    }
}

class Stub : Multiply {
    override fun execute(a: Int, b: Int): Int {
        return 10
    }
}

