package kiranrao.app

fun main() {
  val message = Settings(
    session_duration_seconds = 30.minutesAsSeconds,
    rssi = -50,
    millis_since_boot = 45.minutesAsMillis,
    brightness = 0.3f,
    guid = getGuid(),
    breath_segments = BreathingSegments(
      inhale_duration = 4.5f,
      hold_duration = 5.33f,
      exhale_duration = 4.5f,
      wait_duration = 3.25f,
    )
  )

  prettyPrint(message.encode())
}