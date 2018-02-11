package lin.louis.config

import lin.louis.cmd.*
import org.apache.commons.cli.Options
import java.util.*

class ApplicationConfig(val version: String, val commands: List<Cmd>, val actionCommands: List<ActionCmd>) {
    fun getOptions(): Options {
        val options = Options()
        commands.forEach { options.addOption(it.getOption()) }
        return options
    }
}

fun loadApplicationConfig(): ApplicationConfig {
    val properties = Properties()
    properties.load(ClassLoader.getSystemResourceAsStream("application.properties"))
    val actionCmd: List<ActionCmd> = listOf(
            ADD,
            LIST
    )
    val commands = actionCmd + listOf(
            CONFIG,
            HELP,
            VERBOSE,
            VERSION
    )
    return ApplicationConfig(properties.getProperty("version"), commands, actionCmd)
}
