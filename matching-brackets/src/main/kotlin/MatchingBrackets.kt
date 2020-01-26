object MatchingBrackets {


    fun isValid(input: String): Boolean {
        val brackets = setOf(Brackets('[', ']'), Brackets('{', '}'), Brackets('(', ')'))
        val stack = mutableListOf<Char>()

        for (c in input) {
            for (b in brackets) {
                if (c == b.start) {
                    stack.add(c)
                } else if (c == b.end) {
                    if (stack.size == 0) {
                        return false
                    }
                    val popped = stack.removeAt(stack.size - 1)
                    if (popped != b.start) {
                        return false
                    }
                }
            }
        }
        return stack.size == 0
    }

    data class Brackets(val start: Char, val end: Char)
}
