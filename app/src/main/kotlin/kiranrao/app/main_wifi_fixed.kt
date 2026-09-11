package kiranrao.app

fun main() {
    val withRssi = WifiInfoFixed(
        connected = true,
        rssi = -50
    )
    val encodedWithRssi = withRssi.encode()
    prettyPrint(
        """
        Wifi info with RSSI: ${encodedWithRssi.toHexString()}; 
        Size = ${encodedWithRssi.size} bytes
    """.trimIndent().green
    )
}