import java.lang.IllegalArgumentException
import kotlin.math.pow

class BaseConverter(val base: Int, val num: IntArray) {
    init {
        if (base < 2) {
            throw IllegalArgumentException("Bases must be at least 2.")
        }
        if (num.isEmpty()) {
            throw IllegalArgumentException("You must supply at least one digit.")
        }
        if (num.size != 1 && num[0] == 0) {
            throw IllegalArgumentException("Digits may not contain leading zeros.")
        }
        var allZero = true
        for (n in num) {
            if (n >= base) {
                throw IllegalArgumentException("All digits must be strictly less than the base.")
            }
            if (n < 0) {
                throw IllegalArgumentException("Digits may not be negative.")
            }
            if (n != 0) {
                allZero = false
            }
        }
        if (num.size != 1 && allZero) {
            throw IllegalArgumentException("Digits may not contain leading zeros.")
        }
    }

    val base10 = convertTo10()

    fun convertToBase(newBase: Int): IntArray {
        if (newBase < 2) {
            throw IllegalArgumentException("Bases must be at least 2.")
        }
        val result = mutableListOf<Int>()
        var div = base10
        while (div >= newBase) {
            result.add(div % newBase)
            div /= newBase
        }
        result.add(div)
        result.reverse()
        return result.toIntArray()
    }

    private fun convertTo10(): Int {
        var num10 = 0.0
        for (i in 0..num.lastIndex) {
            num10 += num[i] * base.toDouble().pow((num.lastIndex - i).toDouble())
        }
        return num10.toInt()
    }
}
