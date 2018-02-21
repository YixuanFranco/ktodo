package lin.louis.cmd

import lin.louis.Task
import lin.louis.parse
import org.apache.commons.cli.Option
import java.nio.file.Files
import java.nio.file.Path

class ListCmd : AbstractCmd(), ActionCmd {
    private val option = Option("l", "list", false, "print the list of tasks")
    override fun getOption(): Option {
        return option
    }

    override fun execute(p: Path, arg: String) {
        val tasks = ArrayList<Task>()
        val stream = Files.newBufferedReader(p)
        stream.buffered().lines().forEach { line -> tasks.add(parse(line)) }
        tasks.forEach { println(it) }
    }
}