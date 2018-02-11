package lin.louis.cmd

import org.apache.commons.cli.CommandLine
import org.apache.commons.cli.Option

interface Cmd {
    fun getOption(): Option
    fun isEnabled(line: CommandLine): Boolean
    fun getOptionValue(line: CommandLine): String?
}

val VERBOSE = VerboseCmd()
val HELP = HelpCmd()
val VERSION = VersionCmd()
val CONFIG = ConfigCmd()
val LIST = ListCmd()
val ADD = AddCmd()