package com.sizealike

import kotlin.test.Test
import kotlin.test.assertEquals

class CollectionExtensionsTest {

    // -- List (implements Collection) --

    @Test fun emptyList() {
        val a = emptyList<Int>()
        assertEquals(0, a.size)
        assertEquals(0, a.length)
        assertEquals(0, a.count)
    }

    @Test fun singleElement() {
        val a = listOf(42)
        assertEquals(1, a.size)
        assertEquals(1, a.length)
        assertEquals(1, a.count)
    }

    @Test fun multipleElements() {
        val a = listOf(1, 2, 3, 4, 5)
        assertEquals(5, a.size)
        assertEquals(5, a.length)
        assertEquals(5, a.count)
    }

    @Test fun stringList() {
        val a = listOf("hello", "world")
        assertEquals(2, a.size)
        assertEquals(2, a.length)
        assertEquals(2, a.count)
    }

    @Test fun nestedList() {
        val a = listOf(listOf(1, 2), listOf(3, 4), listOf(5, 6))
        assertEquals(3, a.size)
        assertEquals(3, a.length)
        assertEquals(3, a.count)
    }

    @Test fun nullableElementList() {
        val a = listOf<Int?>(1, null, 3, null, 5)
        assertEquals(5, a.size)
        assertEquals(5, a.length)
        assertEquals(5, a.count)
    }

    @Test fun largeList() {
        val a = (0 until 10_000).toList()
        assertEquals(10_000, a.size)
        assertEquals(10_000, a.length)
        assertEquals(10_000, a.count)
    }

    @Test fun subList() {
        val a = listOf(1, 2, 3, 4, 5)
        val slice = a.subList(1, 4)
        assertEquals(3, slice.size)
        assertEquals(3, slice.length)
        assertEquals(3, slice.count)
    }

    @Test fun listAllThreeAccessorsAgree() {
        val a = listOf(1, 2, 3)
        assertEquals(a.size, a.count)
        assertEquals(a.length, a.count)
    }

    // -- Set (implements Collection) --

    @Test fun emptySet() {
        val s = emptySet<Int>()
        assertEquals(0, s.size)
        assertEquals(0, s.length)
        assertEquals(0, s.count)
    }

    @Test fun singleElementSet() {
        val s = setOf(1)
        assertEquals(1, s.size)
        assertEquals(1, s.length)
        assertEquals(1, s.count)
    }

    @Test fun multipleElementSet() {
        val s = setOf(1, 2, 3, 4, 5)
        assertEquals(5, s.size)
        assertEquals(5, s.length)
        assertEquals(5, s.count)
    }

    @Test fun duplicatesCollapsed() {
        val s = setOf(1, 1, 2, 2, 3)
        assertEquals(3, s.size)
        assertEquals(3, s.length)
        assertEquals(3, s.count)
    }

    @Test fun stringSet() {
        val s = setOf("a", "b", "c")
        assertEquals(3, s.size)
        assertEquals(3, s.length)
        assertEquals(3, s.count)
    }

    @Test fun setAllThreeAccessorsAgree() {
        val s = setOf(10, 20, 30)
        assertEquals(s.size, s.count)
        assertEquals(s.length, s.count)
    }

    // -- Mutability --

    @Test fun mutableListAfterAdd() {
        val a = mutableListOf(1, 2, 3)
        assertEquals(3, a.size)
        a.add(4)
        assertEquals(4, a.size)
        assertEquals(4, a.length)
        assertEquals(4, a.count)
    }

    @Test fun mutableListAfterRemove() {
        val a = mutableListOf(1, 2, 3)
        a.removeLast()
        assertEquals(2, a.size)
        assertEquals(2, a.length)
        assertEquals(2, a.count)
    }

    @Test fun mutableSetAfterAdd() {
        val s = mutableSetOf(1, 2)
        s.add(3)
        assertEquals(3, s.size)
        assertEquals(3, s.length)
        assertEquals(3, s.count)
    }
}
