package lin.louis

const val SEPARATOR = ";"

data class Task(var name: String, var isDone: Boolean = false) {
    override fun toString(): String {
        val done = if (isDone) "X" else ""
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
