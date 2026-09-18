package kiranrao.app

import okio.ByteString
import kotlin.time.Duration.Companion.hours

fun main() {
  val realisticMaxMessageId60hz = 8.hours.inWholeSeconds * 60
  val estimatedFragments = estimatedFragmentsFor10MB()
  val overhead = Envelope(
    message_id = realisticMaxMessageId60hz.toInt(),
    total_fragments = estimatedFragments,
    fragment_index = estimatedFragments - 1,
    payload = ByteString.EMPTY,
  )

  val encodedOverhead = overhead.encode()

  prettyPrint("""
     RealisticMaxMessageId60hz: $realisticMaxMessageId60hz
     EstimatedFragments: $estimatedFragments
     Overhead size: ${encodedOverhead.size} bytes
    """.trimIndent()
  )
}



























private fun estimatedFragmentsFor10MB(): Int {
  return 10 * 1024 * 1024 / 8
}