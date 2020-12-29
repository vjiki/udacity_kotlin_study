package Aquarium

// without generics we need to implement
// a new copy of list for each type
class MyIntList {
    fun get (pos: Int): Int {return 0}
    fun addItem(item: Int) {}
}

class MyShortList {
    fun get(pos: Int): Short {return 0}
    fun addItem(item: Short) {}
}

// With generics we can make the list generic
// so it can hold any type of object.
// generic type is <T>

// list of T
class MyList<T> {

    fun get(pos: Int): T {
        TODO("implement")
    }
    fun addItem(item: T) {}
}

fun workWithMyList() {

    // making a MyList of string and MyList of fish
    val intList: MyList<String>
    val fishList: MyList<Fish>
}