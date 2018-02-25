package lin.louis

import lin.louis.config.getConfigFromFile
import java.io.InputStreamReader
import java.nio.charset.StandardCharsets
import kotlin.test.*

class DataConfigTest {
    @Test
    fun test_getConfigFromFile() {
        val reader = InputStreamReader(javaClass.classLoader.getResourceAsStream("ktodo.properties"), StandardCharsets.UTF_8)
        val config = getConfigFromFile(reader)

        assertNotNull(config)
        assertEquals("/tmp/ktodo", config.dataFilePath)
    }
}