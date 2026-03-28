# SizeAlike for Kotlin

SizeAlike is a lightweight Kotlin library that unifies collection sizing across the standard library. It adds `.size`, `.length`, and `.count` as interchangeable properties on all collection types, arrays, maps, and strings, so you never have to remember which accessor a given type uses.

Kotlin's `Collection` and `Map` provide `.size`. `String` provides `.length`. Other languages use `.count`. SizeAlike bridges the gap by making all three work everywhere.

## Supported Types

**Via `Collection` extension:** List, Set, MutableList, MutableSet, and any other type implementing `Collection`.

**Via `Map` extension:** Map, MutableMap, HashMap, LinkedHashMap, and any other type implementing `Map`.

**Via `String` extension:** String.

**Via `Array` extensions:** Array\<T>, IntArray, LongArray, DoubleArray, FloatArray, BooleanArray, ByteArray, ShortArray, and CharArray.

## Performance

All extensions are declared `inline`, which allows the Kotlin compiler to inline the property access directly at the call site. This means `.length` and `.count` on a collection compile down to the same bytecode as `.size`. There is zero runtime overhead.

## Requirements

- Kotlin 2.1.0+
- JDK 17+

## Installation

Add the JitPack repository to your `settings.gradle.kts`:

```kotlin
dependencyResolutionManagement {
    repositories {
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
    }
}
```

Then add SizeAlike as a dependency in your module's `build.gradle.kts`:

```kotlin
dependencies {
    implementation("com.github.mcmooneyham:Size-Alike-Kotlin:1.0.0")
}
```

## Usage

```kotlin
import com.sizealike.*

val list = listOf(1, 2, 3)
list.size    // 3
list.length  // 3
list.count   // 3

val string = "hello"
string.length // 5
string.size   // 5
string.count  // 5

val map = mapOf("a" to 1, "b" to 2)
map.size      // 2
map.length    // 2
map.count     // 2

val array = intArrayOf(1, 2, 3)
array.size    // 3
array.length  // 3
array.count   // 3
```

## License

SizeAlike is available under the MIT License. See [LICENSE](LICENSE) for details.
