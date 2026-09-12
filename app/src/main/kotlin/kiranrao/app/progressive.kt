package kiranrao.app

import kotlin.time.Duration.Companion.minutes
import kotlin.uuid.Uuid

fun main() {
    val uuid = Uuid.parseHexDash("fc3959e4-8f99-41d2-8874-130f5e581553")
    val (msb, lsb) = uuid.toLongs { msb, lsb ->
        msb to lsb
    }
    val message = Settings(
        session_duration_seconds = 30.minutesAsSecondsInt,
        rssi = -50,
        millis_since_boot = 45.minutes.inWholeMilliseconds.toInt(),
        brightness_percent = 30,
        guid_msb = msb,
        guid_lsb = lsb,
        inhale_duration_ms = 4500,
        hold_duration_ms = 5330,
        exhale_duration_ms = 4500,
        wait_duration_ms = 3250,
    )

    val encoded = message.encode()
    prettyPrint("""
        Encoded message: ${encoded.toHexString()}
        Size: ${encoded.size} bytes
    """.trimIndent())
}