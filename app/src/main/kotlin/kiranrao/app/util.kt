package kiranrao.app

import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.minutes
import kotlin.time.Duration.Companion.seconds
import kotlin.time.DurationUnit

enum class MtuSize(val size: Int) {
    MTU_23(23),
    MTU_158(158),
    MTU_185(185),
    MTU_247(247),
    MTU_517(517);

    fun availablePayloadSize() = size - 3
}

internal val Int.secondsInt get() = this.seconds.inWholeSeconds.toInt()
internal val Int.millisecondsInt get() = this.milliseconds.inWholeMilliseconds.toInt()
internal val Int.minutesAsSecondsInt get() = this.minutes.inWholeSeconds.toInt()
internal val Double.secondsFloat get() = this.seconds.toDouble(DurationUnit.SECONDS).toFloat()

internal val String.green get() = "\u001B[32m$this\u001B[0m"

internal fun prettyPrint(string: String) {
    println("================================\n\n\n")
    println(string.green)
    println("\n\n\n================================")
}