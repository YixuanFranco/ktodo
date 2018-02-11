package lin.louis.cmd

import org.apache.commons.cli.Option

class VerboseCmd : AbstractCmd() {
    private val option = Option("ve", "verbose", false, "debug mode")
    override fun getOption(): Option {
        return option
    }
}
