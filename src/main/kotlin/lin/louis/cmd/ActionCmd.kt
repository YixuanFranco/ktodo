package lin.louis.cmd

import java.nio.file.Path

interface ActionCmd: Cmd {
    fun execute(p: Path, arg: String)
}