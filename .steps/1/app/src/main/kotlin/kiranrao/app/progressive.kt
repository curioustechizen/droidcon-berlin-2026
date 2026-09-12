package kiranrao.app

import kotlin.time.Duration.Companion.minutes
import kotlin.uuid.Uuid

fun main() {
    val uuid = Uuid.parseHexDash("fc3959e4-8f99-41d2-8874-130f5e581553")
    val guid = uuid.toLongs { msb, lsb ->
        Guid(msb, lsb)
    }
    val message = Settings(
        session_duration_seconds = 30.minutesAsSecondsInt,
        rssi = -50,
        millis_since_boot = 45.minutes.inWholeMilliseconds.toInt(),
        brightness = 0.3f,
        guid = guid,
        breath_segments = BreathingSegments(
            inhale_duration = 4.5f,
            hold_duration = 5.33f,
            exhale_duration = 4.5f,
            wait_duration = 3.25f,
        )
    )

    val encoded = message.encode()
    prettyPrint("""
        Encoded message: ${encoded.toHexString()}
        Size: ${encoded.size} bytes
    """.trimIndent())
}