package lin.louis

import lin.louis.cmd.AddCmd
import java.nio.file.Files
import java.nio.file.Paths
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class AddCmdTest {
    private val cmd = AddCmd()
    private val path = Paths.get("/tmp/ktodo_test_add")

    @BeforeTest
    fun setUp() {
        Files.deleteIfExists(path)
    }

    @Test
    fun test_execute() {
        // WHEN
        cmd.execute(path, "foo")

        // THEN
        assertEquals("foo;false", Files.newBufferedReader(path).readLine())
    }
}