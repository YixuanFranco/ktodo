package lin.louis

val SEPARATOR = ";"

class Task(var name: String, var isDone: Boolean = false) {
    override fun toString(): String {
        var done = ""
        if (isDone) {
            done = "X"
        }
        return "$name \t$done"
    }

    fun toLine(): String {
        return "$name$SEPARATOR$isDone"
    }
}

fun parse(line: String): Task {
    val array = line.split(SEPARATOR)
    if (array.size < 2) {
        return Task("", false)
    }
    return Task(sanitize(array[0]), sanitize(array[1]).toBoolean())
}

fun sanitize(s: String): String {
    return s.replace("\n", "")
}
