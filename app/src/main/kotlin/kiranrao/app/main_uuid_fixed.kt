package kiranrao.app

fun main() {
    val uuidMessage = kotlin.uuid.Uuid.random().toLongs { msb, lsb ->
        UuidFixed(msb, lsb)
    }

    val encoded = uuidMessage.encode()

    prettyPrint(
        """
        UUID: ${encoded.toHexString()} 
        Size = ${encoded.size} bytes
    """.trimIndent().green
    )
}