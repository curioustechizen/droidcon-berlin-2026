package kiranrao.app

import okio.ByteString

fun main() {
  val overhead = Envelope(
    message_id = 0,
    total_fragments = 1,
    fragment_index = 0,
    encrypted_payload = ByteString.EMPTY,
  )
}