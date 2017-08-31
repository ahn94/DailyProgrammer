package TalkingClockE321

class T24 (time: String){

    val hourWords: List<String> = listOf("twelve", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve")
    val minOne: List<String> = listOf("oh", "ten", "twenty", "thirty", "forty", "fifty")
    val minTwo: List<String> = listOf("", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine")

    private val strTime: String = time
    var hour: Int
    var min: Int
    val minTens: Int
    val minOnes: Int
    val isAM: Boolean

    init {
        val clock: List<String> = time.split(":")

        hour = clock[0].toInt()
        min = clock[1].toInt()

        minTens = min / 10
        minOnes = min % 10

        isAM = hour < 12

        hour %= 12
    }

    override fun toString(): String {
        return "It's ${hourWords[hour]} ${printMin()}${printAMPM()}"
    }

    private fun printAMPM(): String {
        return if (isAM) "am" else "pm"
    }

    private fun printMin(): String {
        var strMin = ""
        if (min != 0) {
            strMin = "${minOne[minTens]} ${minTwo[minOnes]} "
        }
        return strMin
    }
}