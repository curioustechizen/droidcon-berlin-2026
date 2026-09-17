package kiranrao.app

fun main() {
  val envelope = Envelope(
    message_id = 0,
    total_fragments = 1,
    fragment_index = 0,
    payload = settingsEncoded
  )

  prettyPrint(envelope.encode())
}














val settingsEncoded = Settings(
  session_duration_seconds = 30.minutesAsSeconds,
  inhale_duration_ms = 4500,
  hold_duration_ms = 5330,
  exhale_duration_ms = 4500,
  wait_duration_ms = 3250,
).encodeByteString()
