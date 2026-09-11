package kiranrao.app

fun main() {
    val breathingSettings = BreathingSettings(
        inhale_duration = 4,
        hold_duration = 7,
        exhale_duration = 8,
        wait_duration = 5,
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

