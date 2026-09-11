package kiranrao.app

fun main() {
    val brightness = BrightnessFloat(0.5f)
    val encoded = brightness.encode()

    prettyPrint("""
        Brightness encoded = ${encoded.toHexString()}
        Size = ${encoded.size} bytes
    """.trimIndent())
}