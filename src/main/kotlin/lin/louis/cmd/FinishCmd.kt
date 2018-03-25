package lin.louis.cmd

import lin.louis.Task
import lin.louis.parse
import org.apache.commons.cli.Option
import java.io.File
import java.nio.file.Path

class FinishCmd : AbstractCmd(), ActionCmd {
    private val option = Option("f", "finish", true, "finish a task")
    override fun getOption(): Option {
        return option
    }

    override fun execute(p: Path, arg: String) {
        val task = Task(arg)
        val tasks = p.toFile().readLines().map { parse(it) }
        tasks.filter { it.name == task.name }.forEach { it.isDone = true }
        File(p.toString()).printWriter().use { out ->
            tasks.forEach { out.println(it.toLine()) }
        }
    }
}