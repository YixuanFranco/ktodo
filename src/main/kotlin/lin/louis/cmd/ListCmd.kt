package lin.louis.cmd

import lin.louis.Todo
import lin.louis.parse
import org.apache.commons.cli.Option
import java.nio.file.Files
import java.nio.file.Path

class ListCmd : AbstractCmd(), ActionCmd {
    private val option = Option("l", "list", false, "print the list of todos")
    override fun getOption(): Option {
        return option
    }

    override fun execute(p: Path, arg: String) {
        val todos = ArrayList<Todo>()
        val stream = Files.newBufferedReader(p)
        stream.buffered().lines().forEach { line -> todos.add(parse(line)) }
        todos.forEach { println(it) }
    }
}