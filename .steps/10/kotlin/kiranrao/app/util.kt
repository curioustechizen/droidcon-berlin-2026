package kiranrao.app

import kotlin.time.Duration.Companion.minutes
import kotlin.uuid.Uuid

enum class MtuSize(val size: Int) {
  MTU_23(23),
  MTU_158(158),
  MTU_185(185),
  MTU_247(247),
  MTU_517(517);

  fun availablePayloadSize() = size - 3
}

internal val Int.minutesAsSeconds get() = this.minutes.inWholeSeconds.toInt()
internal val Int.minutesAsMillis get() = this.minutes.inWholeMilliseconds.toInt()

internal val String.green get() = "\u001B[32m$this\u001B[0m"

internal fun getUuid(): Pair<Long, Long> {
  val uuid = Uuid.parseHexDash("fc3959e4-8f99-41d2-8874-130f5e581553")
  return uuid.toLongs { msb, lsb ->
    msb to lsb
  }
}

internal fun getGuid(): Guid {
  val (msb, lsb) = getUuid()
  return Guid(msb, lsb)
}

internal fun prettyPrint(encoded: ByteArray) {
  prettyPrint(
    """
        Encoded: ${encoded.toHexString()}
        Size: ${encoded.size} bytes
    """.trimIndent()
  )
}

internal fun prettyPrint(string: String) {
  println(
    """
================================
        
$string
        
================================""".green
  )
}