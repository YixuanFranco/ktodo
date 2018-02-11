package lin.louis

val SEPARATOR = ";"

class Todo (var name: String, var isDone: Boolean = false) {
    override fun toString(): String {
        var done = ""
        if (isDone) {
            done = "X"
        }
        return "$name \t$done"
    }

    fun toLine(): String {
        return "$name$SEPARATOR"
    }
}

fun parse(line: String): Todo {
    val array = line.split(SEPARATOR)
    if (array.size < 2) {
        return Todo("", false)
    }
    return Todo(sanitize(array[0]), sanitize(array[1]).toBoolean())
}

fun sanitize(s: String): String {
    return s.replace("\n", "")
}
