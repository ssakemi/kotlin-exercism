const val NUMBER_OF_ALPHABET = 26

fun isPangram(str: String): Boolean {
    if (str.length < NUMBER_OF_ALPHABET) {
        return false
    }

    val chars = hashSetOf<Char>()
    for (i in 0 until str.length) {
        val c = str[i].toLowerCase()
        if(c in 'a'..'z') {
            chars.add(c)
        }
    }
    return chars.size == NUMBER_OF_ALPHABET
}