package lin.louis

import lin.louis.cmd.*
import org.apache.commons.cli.DefaultParser
import org.apache.commons.cli.Options
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import java.nio.file.Paths
import kotlin.test.*

class ListCmdTest {
    private val cmd = ListCmd()
    private val options = Options()

    @BeforeTest
    fun setUp() {
        options.addOption(ADD.getOption())
        options.addOption(CONFIG.getOption())
        options.addOption(FINISH.getOption())
        options.addOption(HELP.getOption())
        options.addOption(LIST.getOption())
        options.addOption(VERBOSE.getOption())
        options.addOption(VERSION.getOption())
    }

    @Test
    fun test_isEnabled() {
        // GIVEN
        val parser = DefaultParser()
        val lineShort = parser.parse(options, arrayOf("-l"))
        val lineLong = parser.parse(options, arrayOf("--list"))

        // WHEN
        val resultShort = cmd.isEnabled(lineShort)
        val resultLong = cmd.isEnabled(lineLong)

        // THEN
        assertTrue(resultShort)
        assertTrue(resultLong)
    }


    @Test
    fun test_isEnabled_withNonPresentOption() {
        // GIVEN
        val line = DefaultParser().parse(options, arrayOf("-v"))

        // WHEN
        val result = cmd.isEnabled(line)

        // THEN
        assertFalse(result)
    }

    @Test
    fun test_execute() {
        // GIVEN
        val bo = ByteArrayOutputStream()
        System.setOut(PrintStream(bo))

        // WHEN
        val resource = javaClass.classLoader.getResource("ktodo.txt")
        cmd.execute(Paths.get(resource.file), "")

        // THEN
        bo.flush()
        val result = String(bo.toByteArray())
        assertEquals(expected =
        "foo \tX\n" +
                "bar \t\n" +
                "foobar \t\n",
                actual = result)
    }
}