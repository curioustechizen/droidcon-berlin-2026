package kiranrao.app

fun main() {
  val int32 = NegativeInt(number = -1)
  val sint32 = NegativeSint(number = -1)

  val intEncoded = int32.encode()
  val sintEncoded = sint32.encode()

  prettyPrint(
    """
        intEncoded: ${intEncoded.toHexString()}
        Size: ${intEncoded.size} bytes
        sintEncoded: ${sintEncoded.toHexString()}
        Size: ${sintEncoded.size} bytes
    """.trimIndent()
  )
}