package com.example.learningkotlin.coroutines

import junit.framework.Assert.assertEquals
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.runBlocking
import org.junit.Test

class MyTest {

    // This is also a way to write unit-tests for suspending functions:
    @Test
    fun testMySuspendingFunction() = runBlocking {
        val x = 2
        val result = 2 + 2 * 2
        delay(3000)
        assertEquals(6, result)
    }
}