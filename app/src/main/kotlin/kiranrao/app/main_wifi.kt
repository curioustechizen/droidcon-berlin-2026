package kiranrao.app

fun main() {
    val wifiInfo = WifiInfo(
        connected = false
    )
    val encoded = wifiInfo.encode()
    val withRssi = WifiInfo(
        connected = true,
        rssi = -50
    )
    val encodedWithRssi = withRssi.encode()
    prettyPrint(
        """
        Wifi info: ${encoded.toHexString()}; Size = ${encoded.size} bytes
        Wifi info with RSSI: ${encodedWithRssi.toHexString()}; Size = ${encodedWithRssi.size} bytes
    """.trimIndent().green
    )
}