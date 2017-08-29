package Ch329

fun main(args : Array<String>) {
    var numbers: List<Int> = (1..4999) + 5000
    numbers = removeEven(numbers)
    val number = 10
    var i = 1
    while (i < numbers.size/2) {
        numbers = remove(numbers, i)
        i++
    }

    if (numbers.contains(number)) {
        println("$number is a lucky number")
    } else {
        val results = getAdjacent(number, numbers)
        println("${results[0]} > $number > ${results[1]}")
    }
}

fun remove(list: List<Int>, n: Int): List<Int> {
    val newList: MutableList<Int> = arrayListOf()
    for (i in list.indices) {
        if (i <= n) {
            newList.add(list[i])
        } else if ((i + 1) % list[n] != 0) {
            newList.add(list[i])
        }
    }
    return newList
}

fun removeEven(list: List<Int>): List<Int> {
    val newList: MutableList<Int> = arrayListOf()
    list.indices
            .asSequence()
            .filter { list[it] % 2 != 0 }
            .mapTo(newList) { list[it] }
    return newList
}

fun getAdjacent(number: Int, numbers: List<Int>): IntArray{
    val result = IntArray(2)
    for (n: Int in numbers) {
        if (n < number) {
            result[0] = n
        } else {
            result[1] = n
            break
        }
    }
    return result
}