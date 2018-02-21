package lin.louis.cmd

import lin.louis.Task
import lin.louis.debug
import lin.louis.parse
import org.apache.commons.cli.Option
import java.io.File
import java.nio.file.Files
import java.nio.file.Path

class FinishCmd : AbstractCmd(), ActionCmd {
    private val option = Option("f", "finish", true, "finish a task")
    override fun getOption(): Option {
        return option
    }

    override fun execute(p: Path, arg: String) {
        val task = Task(arg)

        val tasks = ArrayList<Task>()
        val readerStream = Files.newBufferedReader(p)
        readerStream.buffered().lines().forEach { line ->
            val t = parse(line)
            if (t.name == task.name) {
                t.isDone = true
                debug("Finishing task: $t")
            }
            tasks.add(t)
        }
        File(p.toString()).printWriter().use { out ->
            tasks.forEach { out.println(it.toLine()) }
        }
    }
}