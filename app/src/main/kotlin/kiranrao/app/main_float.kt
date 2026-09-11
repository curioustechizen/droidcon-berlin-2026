package kiranrao.app

fun main() {
    val breathingSettings = BreathingSettingsFloat(
        inhale_duration = 4.5f,
        hold_duration = 5.33f,
        exhale_duration = 4.5f,
        wait_duration = 3.25f,
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

