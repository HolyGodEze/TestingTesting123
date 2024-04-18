package com.example.testingtesting123

import org.junit.Assert.*

import org.junit.Before
import org.junit.Test

class UniqueCollectionTest {

    lateinit var collection: UniqueCollection

    @Before
    fun setUp() {
        collection = UniqueCollection()
    }

    @Test
    fun addAnItem() {
        collection.addItem(Item("Item1"))
        val item = collection.get(0)
        assert(item.name == "Item1")
    }

    @Test
    fun addUniqueItem() {
        collection.addItem(Item("Item1"))
        collection.addItem(Item("item1"))
        collection.addItem(Item("Item2"))

        assert (collection.size() == 2)
    }

    @Test
    fun clearAllItems() {
        collection.addItem(Item("item1"))
        collection.addItem(Item("Item2"))

        val originalSize = collection.size()
        collection.clear()
        val newSize = collection.size();

        assert(originalSize == 2 && newSize == 0) {"Items not cleared"}
    }

    @Test
    fun getItem(){
        val item1 = Item("item1")
        val item2 = Item("item2")
        collection.addItem(item1)
        collection.addItem(item2)

        assert(item2 == collection.get(1)) {"Wrong item"}

    }

    @Test
    fun removeAnItem(){
        collection.addItem(Item("item1"))
        collection.addItem(Item("item2"))
        collection.addItem(Item("item3"))

        val item = Item("item1")
        collection.remove(item)

        assert(!collection.contains(item)) {"Item in collection"}
    }
        @Test
    fun removeItemNotInList() {
        collection.addItem(Item("item1"))
        collection.addItem(Item("item2"))
        collection.addItem(Item("item3"))

        val item = Item("item4")
        collection.remove(item)

        assert(!collection.contains(item)) {"Item not removed"}
    }

    @Test
    fun removeItemInEmptyList() {
        val emptyCollection = UniqueCollection()

        val item = Item("item4")
        emptyCollection.remove(item)

        assert(!emptyCollection.contains(item)) {"Item not removed"}
    }
}