package kiranrao.app

fun main() {
  val guid = getGuid()
  val message = Settings(
    session_duration_seconds = 30.minutesAsSecondsInt,
    rssi = -50,
    millis_since_boot = 45.minutes.inWholeMilliseconds.toInt(),
    brightness_percent = 30,
    guid_msb = guid.msb,
    guid_lsb = guid.lsb,
    inhale_duration_ms = 4500,
    hold_duration_ms = 5330,
    exhale_duration_ms = 4500,
    wait_duration_ms = 3250,
  )

  prettyPrint(message.encode())
}