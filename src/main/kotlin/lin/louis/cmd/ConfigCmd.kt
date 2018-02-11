package lin.louis.cmd

import lin.louis.config.DataConfig
import lin.louis.config.getConfigFromFile
import lin.louis.createFileIfNotExists
import lin.louis.debug
import org.apache.commons.cli.Option
import java.nio.file.Files

class ConfigCmd : AbstractCmd() {
    private val option = Option("c", "config", true, "set the config file path")
    override fun getOption(): Option {
        return option
    }

    fun execute(t: String): DataConfig {
        val path = createFileIfNotExists(t)
        debug("Reading from config '$path'...")
        val config = getConfigFromFile(Files.newBufferedReader(path))
        debug("DataConfig loaded with the following values: $config")
        return config
    }
}