package lin.louis.cmd

import lin.louis.Task
import org.apache.commons.cli.Option
import java.nio.file.Path

class AddCmd: AbstractCmd(), ActionCmd {
    private val option = Option("a", "add", true, "add a task")
    override fun getOption(): Option {
        return option
    }

    override fun execute(p: Path, arg: String) {
        // I have to add the empty string, otherwise, it's not going to add a new line
        p.toFile().appendText("" + Task(arg).toLine())
    }
}