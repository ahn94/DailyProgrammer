package TalkingClockE321

val hourWords: List<String> = listOf("twelve", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve")
val minOne: List<String> = listOf("oh", "ten", "twenty", "thirty", "forty", "fifty")
val minTwo: List<String> = listOf("", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine")

fun main(args: Array<String>) {
    val times: Array<String> =
            arrayOf("00:00", "01:30", "12:05", "14:01", "20:29", "21:00")
    times.forEach(::printTime)
}

fun printTime(time: String) {
    val clock: List<String> = time.split(":")

    var hour = clock[0].toInt()
    val min = clock[1].toInt()

    val minFirst = min / 10
    val minLast = min % 10

    val amPM = if (hour < 12) "am" else "pm"

    hour %= 12

    if (hour == 0) {
        hour = 12
    }

    var strMin = ""

    if (min != 0) {
        strMin = "${minOne[minFirst]} ${minTwo[minLast]} "
    }

    println("It's ${hourWords[hour]} $strMin$amPM")
    println()
}