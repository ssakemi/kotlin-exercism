class Deque<E> {
    private var current: Node<E>? = null

    fun push(e: E) {
        if (current == null) {
            current = Node(e, null, null)
            return
        }

        while (current?.next != null) {
            current = current?.next
        }
        current?.next = Node(e, current, null)
    }

    // never be called on empty list
    fun pop(): E? {
        while (current?.next != null) {
            current = current?.next
        }
        val value = current?.value
        current = current?.prev
        current?.next = null
        return value
    }

    fun unshift(e: E) {
        if (current == null) {
            current = Node(e, null, null)
            return
        }

        while (current?.prev != null) {
            current = current?.prev
        }
        current?.prev = Node(e, null, current)
    }

    // never be called on empty list
    fun shift(): E? {
        while (current?.prev != null) {
            current = current?.prev
        }
        val value = current?.value
        current = current?.next
        current?.prev = null
        return value
    }

    class Node<E>(val value: E, var prev: Node<E>?, var next: Node<E>?)
}
