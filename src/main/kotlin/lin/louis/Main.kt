package lin.louis

import lin.louis.cmd.CONFIG
import lin.louis.cmd.HELP
import lin.louis.cmd.VERBOSE
import lin.louis.cmd.VERSION
import lin.louis.config.loadApplicationConfig
import org.apache.commons.cli.DefaultParser
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

var DEBUG_ENABLED = false

fun main(args: Array<String>) {
    val applicationConfig = loadApplicationConfig()

    val parser = DefaultParser()
    val line = parser.parse(applicationConfig.getOptions(), args)

    if (VERBOSE.isEnabled(line)) {
        DEBUG_ENABLED = true
    }
    if (HELP.isEnabled(line)) {
        HELP.execute(applicationConfig.getOptions())
    }
    if (VERSION.isEnabled(line)) {
        VERSION.execute()
    }

    val configPath: String
    val homeFolder = System.getProperty("user.home")
    configPath = CONFIG.getOptionValue(line)?: "$homeFolder/.ktodo.properties"
    val config = CONFIG.execute(configPath)

    val path = createFileIfNotExists(config.dataFilePath)

    val cmd = applicationConfig.actionCommands.find { it.isEnabled(line) }
    cmd?.execute(path, cmd.getOptionValue(line)?: "")
}

fun createFileIfNotExists(filePath: String): Path {
    val path = Paths.get(filePath)
    if (!Files.exists(path)) {
        Files.createFile(path)
    }
    return path
}

fun debug(message: String) {
    if (DEBUG_ENABLED) {
        println("[DEBUG] $message")
    }
}