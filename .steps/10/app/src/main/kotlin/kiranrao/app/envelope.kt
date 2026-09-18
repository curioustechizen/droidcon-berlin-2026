package kiranrao.app

import okio.ByteString
import kotlin.time.Duration.Companion.hours

fun main() {
  val realisticMaxMessageId60hz = 8.hours.inWholeSeconds * 60
  val overhead = Envelope(
    message_id = realisticMaxMessageId60hz.toInt(),
    total_fragments = 1,
    fragment_index = 0,
    payload = ByteString.EMPTY,
  )

  val encodedOverhead = overhead.encode()

  prettyPrint("""
     RealisticMaxMessageId60hz: $realisticMaxMessageId60hz
     Overhead size: ${encodedOverhead.size} bytes
    """.trimIndent()
  )
}
