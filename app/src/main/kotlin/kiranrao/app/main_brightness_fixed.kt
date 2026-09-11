package kiranrao.app

fun main() {
    val brightness = BrightnessInt(50)
    val encoded = brightness.encode()

    prettyPrint("""
        Brightness encoded = ${encoded.toHexString()}
        Size = ${encoded.size} bytes
    """.trimIndent())
}