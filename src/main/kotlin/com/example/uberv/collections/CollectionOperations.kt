package com.example.uberv.collections

/**
Although we can just use Java collections, Kotlin provides a good set of native interfaces you will want to use:

• [Iterable]: The parent class. Any classes that inherit from this interface represent
a sequence of elements we can iterate over.

• [MutableIterable]: Iterables that support removing items during iteration.

• [Collection]: This class represents a generic collection of elements. We get access to
functions that return the size of the collection, whether the collection is empty,
contains an item or a set of items. All the methods for this kind of collections are
only to request data, because collections are immutable (read-only).

• [MutableCollection]: a Collection that supports adding and removing elements.
It provides extra functions such as add, remove or clear among others.

• [List]: Probably the most used collection. It represents a generic ordered collection of elements.
As it’s ordered, we can request an item by its position, using the get function. (read-only)

• [MutableList]: a List that supports adding and removing elements.

• [Set]: an unordered collection of elements that doesn’t support duplicate elements.

• [MutableSet]: a Set that supports adding and removing elements.

• [Map]: a collection of key-value pairs. The keys in a map are unique,
which means we cannot have two pairs with the same key in a map.

• [MutableMap]: a Map that supports adding and removing elements.
 */

fun main(args: Array<String>) {
    // Aggregate operations
    // any - returns true if at least one element matches given predicate
    val list = listOf(1, 2, 3, 4, 5, 6) // returns a read-only List
    val a = (list.any { it % 2 == 0 })
    val b = (list.any { it > 10 })
    print("a=$a, b=$b")
}