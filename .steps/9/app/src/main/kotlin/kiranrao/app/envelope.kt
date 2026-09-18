package kiranrao.app

import okio.ByteString
import okio.ByteString.Companion.toByteString

fun main() {
  val overhead = Envelope(
    message_id = 0,
    total_fragments = 1,
    fragment_index = 0,
    payload = ByteString.EMPTY,
  )

  val encodedOverhead = overhead.encode()

  val fragment1Size = MtuSize.MTU_23.availablePayloadSize() - encodedOverhead.size
  val envelope1 = getEnvelope1(fragment1Size)
  val envelope2 = getEnvelope2(fragment1Size)

  prettyPrint("""
      Overhead size: ${encodedOverhead.size} bytes
      Envelope1 size: ${envelope1.size} bytes
      Envelope2 size: ${envelope2.size} bytes
    """.trimIndent()
  )
}





















private fun getEnvelope1(fragment1Size: Int): ByteArray = Envelope(
  message_id = 0,
  total_fragments = 2,
  fragment_index = 0,
  payload = settingsEncoded.toByteString(0, fragment1Size)
).encode()

private fun getEnvelope2(fragment1Size: Int): ByteArray = Envelope(
  message_id = 0,
  total_fragments = 2,
  fragment_index = 1,
  payload = settingsEncoded.toByteString(fragment1Size, settingsEncoded.size - fragment1Size)
).encode()

private val settingsEncoded = Settings(
  session_duration_seconds = 30.minutesAsSeconds,
  inhale_duration_ms = 4500,
  hold_duration_ms = 5330,
  exhale_duration_ms = 4500,
  wait_duration_ms = 3250,
).encode()