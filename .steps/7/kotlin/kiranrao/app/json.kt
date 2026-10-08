package kiranrao.app

import org.intellij.lang.annotations.Language

fun main() {
  @Language("JSON")
  val settingsJson = """
    {"sessionDurationSeconds":1800,"rssi":-50,"millisSinceBoot":2700000,"brightnessPercent":30,"guidMsb":"18174656609426948562","guidLsb":"9832504843184903507","inhaleDurationMs":4500,"holdDurationMs":5330,"exhaleDurationMs":4500,"waitDurationMs":3250}
  """.trimIndent()

  @Language("JSON")
  val settingsJsonMinified = """
    {"d":1800,"r":-50,"m":2700000,"b":30,"z":18174656609426948562,"l":9832504843184903507,"i":4500,"h":5330,"e":4500,"w":3250}
  """.trimIndent()

  prettyPrint("""
    settingsJson size = ${settingsJson.count()} bytes
    settingsJsonMinified size = ${settingsJsonMinified.count()} bytes
  """.trimIndent())
}