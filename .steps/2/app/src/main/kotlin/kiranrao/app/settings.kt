package kiranrao.app

fun main() {
  val message = Settings(
    session_duration_seconds = 30.minutesAsSeconds,
    rssi = -50,
    millis_since_boot = 45.minutesAsMillis,
    brightness = 0.3f,
    guid = getGuid(),
    breath_segments = BreathingSegments(
      inhale_duration_ms = 4500,
      hold_duration_ms = 5330,
      exhale_duration_ms = 4500,
      wait_duration_ms = 3250,
    )
  )

  prettyPrint(message.encode())
}