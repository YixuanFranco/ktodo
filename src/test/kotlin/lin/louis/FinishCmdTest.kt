package lin.louis

import lin.louis.cmd.FinishCmd
import java.nio.file.Files
import java.nio.file.Paths
import java.util.stream.Collectors
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class FinishCmdTest {
    private val cmd = FinishCmd()
    private val path = Paths.get("/tmp/ktodo_test_finish")

    @BeforeTest
    fun setUp() {
        Files.deleteIfExists(path)
        Files.createFile(path)
        path.toFile().appendText(Task("foo").toLine() + "\n" + Task("bar").toLine())
    }

    @Test
    fun test_execute() {
        // WHEN
        cmd.execute(path, "bar")

        // THEN
        val result = Files.newBufferedReader(path).lines().collect(Collectors.toList())
        assertEquals(2, result.size)
        assertEquals("foo;false", result[0])
        assertEquals("bar;true", result[1])
    }
}