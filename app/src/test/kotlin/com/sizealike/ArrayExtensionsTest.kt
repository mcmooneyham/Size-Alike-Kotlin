package com.sizealike

import kotlin.test.Test
import kotlin.test.assertEquals

class ArrayExtensionsTest {

    // -- Array<T> --

    @Test fun emptyArray() {
        val a = emptyArray<Int>()
        assertEquals(0, a.size)
        assertEquals(0, a.length)
        assertEquals(0, a.count)
    }

    @Test fun singleElement() {
        val a = arrayOf(42)
        assertEquals(1, a.size)
        assertEquals(1, a.length)
        assertEquals(1, a.count)
    }

    @Test fun multipleElements() {
        val a = arrayOf(1, 2, 3, 4, 5)
        assertEquals(5, a.size)
        assertEquals(5, a.length)
        assertEquals(5, a.count)
    }

    @Test fun stringArray() {
        val a = arrayOf("hello", "world")
        assertEquals(2, a.size)
        assertEquals(2, a.length)
        assertEquals(2, a.count)
    }

    @Test fun nestedArray() {
        val a = arrayOf(arrayOf(1, 2), arrayOf(3, 4), arrayOf(5, 6))
        assertEquals(3, a.size)
        assertEquals(3, a.length)
        assertEquals(3, a.count)
    }

    @Test fun nullableElementArray() {
        val a = arrayOf<Int?>(1, null, 3, null, 5)
        assertEquals(5, a.size)
        assertEquals(5, a.length)
        assertEquals(5, a.count)
    }

    @Test fun largeArray() {
        val a = Array(10_000) { it }
        assertEquals(10_000, a.size)
        assertEquals(10_000, a.length)
        assertEquals(10_000, a.count)
    }

    @Test fun arrayAllThreeAccessorsAgree() {
        val a = arrayOf(1, 2, 3)
        assertEquals(a.size, a.count)
        assertEquals(a.length, a.count)
    }

    // -- IntArray --

    @Test fun emptyIntArray() {
        val a = intArrayOf()
        assertEquals(0, a.size)
        assertEquals(0, a.length)
        assertEquals(0, a.count)
    }

    @Test fun intArray() {
        val a = intArrayOf(1, 2, 3)
        assertEquals(3, a.size)
        assertEquals(3, a.length)
        assertEquals(3, a.count)
    }

    // -- LongArray --

    @Test fun longArray() {
        val a = longArrayOf(1L, 2L, 3L, 4L)
        assertEquals(4, a.size)
        assertEquals(4, a.length)
        assertEquals(4, a.count)
    }

    // -- DoubleArray --

    @Test fun doubleArray() {
        val a = doubleArrayOf(1.0, 2.0, 3.0)
        assertEquals(3, a.size)
        assertEquals(3, a.length)
        assertEquals(3, a.count)
    }

    // -- FloatArray --

    @Test fun floatArray() {
        val a = floatArrayOf(1.0f, 2.0f)
        assertEquals(2, a.size)
        assertEquals(2, a.length)
        assertEquals(2, a.count)
    }

    // -- BooleanArray --

    @Test fun booleanArray() {
        val a = booleanArrayOf(true, false, true)
        assertEquals(3, a.size)
        assertEquals(3, a.length)
        assertEquals(3, a.count)
    }

    // -- ByteArray (equivalent to Swift's Data) --

    @Test fun emptyByteArray() {
        val a = byteArrayOf()
        assertEquals(0, a.size)
        assertEquals(0, a.length)
        assertEquals(0, a.count)
    }

    @Test fun byteArray() {
        val a = byteArrayOf(0x00, 0x01, 0x02, 0x03)
        assertEquals(4, a.size)
        assertEquals(4, a.length)
        assertEquals(4, a.count)
    }

    @Test fun byteArrayFromString() {
        val a = "hello".toByteArray(Charsets.UTF_8)
        assertEquals(5, a.size)
        assertEquals(5, a.length)
        assertEquals(5, a.count)
    }

    @Test fun byteArrayFromUnicodeString() {
        // UTF-8 encodes 👋 as 4 bytes
        val a = "👋".toByteArray(Charsets.UTF_8)
        assertEquals(4, a.size)
        assertEquals(4, a.length)
        assertEquals(4, a.count)
    }

    // -- ShortArray --

    @Test fun shortArray() {
        val a = shortArrayOf(1, 2, 3, 4, 5)
        assertEquals(5, a.size)
        assertEquals(5, a.length)
        assertEquals(5, a.count)
    }

    // -- CharArray --

    @Test fun charArray() {
        val a = charArrayOf('a', 'b', 'c')
        assertEquals(3, a.size)
        assertEquals(3, a.length)
        assertEquals(3, a.count)
    }
}
