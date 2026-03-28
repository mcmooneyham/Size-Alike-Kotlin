package com.sizealike

import kotlin.test.Test
import kotlin.test.assertEquals

class StringExtensionsTest {

    @Test fun emptyString() {
        val s = ""
        assertEquals(0, s.size)
        assertEquals(0, s.length)
        assertEquals(0, s.count)
    }

    @Test fun asciiString() {
        val s = "hello"
        assertEquals(5, s.size)
        assertEquals(5, s.length)
        assertEquals(5, s.count)
    }

    @Test fun unicodeEmoji() {
        // Kotlin String.length counts UTF-16 code units
        // Each emoji here uses 2 UTF-16 code units (surrogate pair)
        val s = "👋🌍"
        assertEquals(4, s.size)
        assertEquals(4, s.length)
        assertEquals(4, s.count)
    }

    @Test fun combinedEmoji() {
        // Family emoji: multiple code points joined by ZWJ
        // Kotlin counts UTF-16 code units, not grapheme clusters
        val s = "👨‍👩‍👧‍👦"
        assertEquals(11, s.size)
        assertEquals(11, s.length)
        assertEquals(11, s.count)
    }

    @Test fun multilineString() {
        val s = "line1\nline2\nline3"
        assertEquals(17, s.size)
        assertEquals(17, s.length)
        assertEquals(17, s.count)
    }

    @Test fun whitespaceOnly() {
        val s = "   "
        assertEquals(3, s.size)
        assertEquals(3, s.length)
        assertEquals(3, s.count)
    }

    @Test fun singleCharacter() {
        val s = "A"
        assertEquals(1, s.size)
        assertEquals(1, s.length)
        assertEquals(1, s.count)
    }

    @Test fun japaneseText() {
        val s = "日本語"
        assertEquals(3, s.size)
        assertEquals(3, s.length)
        assertEquals(3, s.count)
    }

    @Test fun mixedAsciiAndUnicode() {
        // "abc" = 3 + "🎉" = 2 (surrogate pair) + "def" = 3 → 8 UTF-16 code units
        val s = "abc🎉def"
        assertEquals(8, s.size)
        assertEquals(8, s.length)
        assertEquals(8, s.count)
    }

    @Test fun allThreeAccessorsAgree() {
        val s = "consistency check"
        assertEquals(s.size, s.count)
        assertEquals(s.length, s.count)
        assertEquals(s.size, s.length)
    }
}
