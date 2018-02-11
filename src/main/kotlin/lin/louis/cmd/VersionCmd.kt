package lin.louis.cmd

import lin.louis.config.loadApplicationConfig
import org.apache.commons.cli.Option

class VersionCmd: AbstractCmd() {
    private val option = Option("v", "version", false, "print the application version")
    override fun getOption(): Option {
        return option
    }

    fun execute() {
        val applicationConfig = loadApplicationConfig()
        println("ktodo version ${applicationConfig.version}")
    }
}
