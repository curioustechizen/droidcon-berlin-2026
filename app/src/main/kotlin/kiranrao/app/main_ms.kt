package kiranrao.app

fun main() {
    val breathingSettings = BreathingSettingsMs(
        inhale_duration_ms = 4500,
        hold_duration_ms = 5330,
        exhale_duration_ms = 4500,
        wait_duration_ms = 3250,
        session_runtime = 30.minutesAsSecondsInt,
    )

    val encoded = breathingSettings.encode()
    prettyPrint(
        """
        Breathing settings encoded: ${encoded.toHexString()} 
        Size = ${encoded.size} bytes
    """.trimIndent().green
    )
}

