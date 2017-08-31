package TalkingClockE321


fun main(args: Array<String>) {
    val times: Array<String> = arrayOf("00:00", "01:30", "12:05", "14:01", "20:29", "21:00")
    times.forEach { println(T24(it)) }
}
