package lin.louis

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse

class TodoTest {
    @Test fun test_parse() {
        var todo = parse("foo;true")
        assertEquals("foo", todo.name)
        assert(todo.isDone)

        todo = parse("bar;false")
        assertEquals("bar", todo.name)
        assertFalse(todo.isDone)

        todo = parse("bar;")
        assertEquals("bar", todo.name)
        assertFalse(todo.isDone)

        todo = parse("")
        assertEquals("", todo.name)
        assertFalse(todo.isDone)

        todo = parse("foobar;true;azertyyu")
        assertEquals("foobar", todo.name)
        assert(todo.isDone)
    }

    @Test fun test_sanitize() {
        assertEquals("", sanitize(""))
        assertEquals("foobar", sanitize("foobar"))
        assertEquals("foobar", sanitize("foo\nbar\n"))
    }
}