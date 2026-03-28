package com.sizealike

import kotlin.test.Test
import kotlin.test.assertEquals

class MapExtensionsTest {

    @Test fun emptyMap() {
        val d = emptyMap<String, Int>()
        assertEquals(0, d.size)
        assertEquals(0, d.length)
        assertEquals(0, d.count)
    }

    @Test fun singleEntry() {
        val d = mapOf("key" to "value")
        assertEquals(1, d.size)
        assertEquals(1, d.length)
        assertEquals(1, d.count)
    }

    @Test fun multipleEntries() {
        val d = mapOf("a" to 1, "b" to 2, "c" to 3)
        assertEquals(3, d.size)
        assertEquals(3, d.length)
        assertEquals(3, d.count)
    }

    @Test fun intKeyMap() {
        val d = mapOf(1 to "one", 2 to "two", 3 to "three", 4 to "four")
        assertEquals(4, d.size)
        assertEquals(4, d.length)
        assertEquals(4, d.count)
    }

    @Test fun allThreeAccessorsAgree() {
        val d = mapOf("x" to 1, "y" to 2)
        assertEquals(d.size, d.count)
        assertEquals(d.length, d.count)
    }

    // -- Mutability --

    @Test fun mutableMapAfterPut() {
        val d = mutableMapOf("a" to 1)
        d["b"] = 2
        assertEquals(2, d.size)
        assertEquals(2, d.length)
        assertEquals(2, d.count)
    }

    @Test fun mutableMapAfterRemove() {
        val d = mutableMapOf("a" to 1, "b" to 2, "c" to 3)
        d.remove("b")
        assertEquals(2, d.size)
        assertEquals(2, d.length)
        assertEquals(2, d.count)
    }
}
