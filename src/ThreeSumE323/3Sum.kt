package ThreeSumE323

fun main(args: Array<String>) {
    val input: ArrayList<String> = arrayListOf(
            "4 5 -1 -2 -7 2 -5 -3 -7 -3 1"
            , "-1 -6 -3 -7 5 -8 2 -8 1"
            , "-5 -1 -4 2 9 -9 -6 -1 -7"
    )

    input.forEach {
        it.split(" ")
                .map(String::toInt)
                .toIntArray()
                .also({
                    threeSum(it).also({
                        it.forEach(::println)
                        println()
                    })
                })

    }
}

fun threeSum(numbers: IntArray): List<Triple<Int, Int, Int>> {
    val triples: ArrayList<Triple<Int, Int, Int>> = ArrayList()
    val len = numbers.size - 1
    numbers.sort()
    for (first in 0..len) {
        for (second in first+1..len) {
            for (third in second+1..len) {
                val one = numbers[first]
                val two = numbers[second]
                val three = numbers[third]
                if (one + two + three == 0) {
                    triples.add(Triple(one, two, three))
                }
            }
        }
    }
    return triples.distinct()
}