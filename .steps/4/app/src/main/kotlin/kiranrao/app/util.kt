package kiranrao.app

import kotlin.time.Duration.Companion.minutes

enum class MtuSize(val size: Int) {
    MTU_23(23),
    MTU_158(158),
    MTU_185(185),
    MTU_247(247),
    MTU_517(517);

    fun availablePayloadSize() = size - 3
}

internal val Int.minutesAsSecondsInt get() = this.minutes.inWholeSeconds.toInt()

internal val String.green get() = "\u001B[32m$this\u001B[0m"

internal fun prettyPrint(string: String) {
    println("""
================================
================================
        
        
$string
        
        
================================
================================""".green)
}