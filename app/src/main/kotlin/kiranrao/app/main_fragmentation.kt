package kiranrao.app

import okio.ByteString
import okio.ByteString.Companion.toByteString

fun main() {
    val breathingSettings = BreathingSettingsMs(
        inhale_duration_ms = 4500,
        hold_duration_ms = 5330,
        exhale_duration_ms = 4500,
        wait_duration_ms = 3250,
        session_runtime = 30.minutesAsSecondsInt,
    )
    val encodedPayload = breathingSettings.encode()
    val availablePayloadSize = MtuSize.MTU_23.availablePayloadSize()

    val emptyEnvelopeOverhead = Envelope.ADAPTER.encodedSize(
        Envelope(
            message_id = 1,
            total_fragments = 1,
            fragment_index = 0,
            payload = ByteString.EMPTY
        )
    )

    val estimatedFragments = (((encodedPayload.size + emptyEnvelopeOverhead) / availablePayloadSize) + 1)
        .coerceAtLeast(1)

    val envelopeWithPayload = Envelope(
        message_id = 1,
        total_fragments = estimatedFragments,
        fragment_index = estimatedFragments - 1,
        payload = encodedPayload.toByteString()
    )

    val chunks = envelopeWithPayload.chunked(availablePayloadSize - emptyEnvelopeOverhead)

    prettyPrint(
        """
        Available payload size: $availablePayloadSize bytes
        Breathing settings encoded: ${encodedPayload.toHexString()}; size = ${encodedPayload.size} bytes
        Estimated fragments: $estimatedFragments
        Envelope overhead: $emptyEnvelopeOverhead bytes
        Total size with envelope: ${envelopeWithPayload.encode().size} bytes
        Number of chunks: ${chunks.size}
        Chunks:
        ${chunks.joinToString(separator = "\n\t") { "Fragment ${it.fragment_index?.plus(1)}/${it.total_fragments}, payload size = ${it.payload?.size ?: 0} bytes, envelope size = ${it.encode().size}" }}
    """.trimIndent()
    )
}

private fun Envelope.chunked(availablePayloadSize: Int): List<Envelope> {
    val payloads = this.payload?.toByteArray()?.chunked(availablePayloadSize) ?: emptyList()
    return payloads.mapIndexed { index, chunk ->
        Envelope(
            message_id = this.message_id,
            total_fragments = payloads.size,
            fragment_index = index,
            payload = chunk.toByteString()
        )
    }
}

private fun ByteArray.chunked(chunkSize: Int): List<ByteArray> {
    val chunks = mutableListOf<ByteArray>()
    if (this.isEmpty()) {
        return chunks
    }

    for (i in indices step chunkSize) {
        val endIndex = (i + chunkSize).coerceAtMost(this.size)
        val chunk = this.sliceArray(i until endIndex)
        chunks.add(chunk)
    }

    return chunks
}