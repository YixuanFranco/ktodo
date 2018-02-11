package lin.louis.cmd

import org.apache.commons.cli.HelpFormatter
import org.apache.commons.cli.Option
import org.apache.commons.cli.Options

class HelpCmd: AbstractCmd() {
    private val option = Option("h", "help", false, "display the help and exit")
    override fun getOption(): Option = option

    fun execute(t: Options) {
        val formatter = HelpFormatter()
        formatter.printHelp("java -jar ktodo.jar", t)
    }
}