import java.lang.ArithmeticException
import java.lang.IllegalArgumentException

object Prime {
    private val cache = arrayListOf(2)
    private var biggestPrime = 2

    @Throws(IllegalArgumentException::class)
    fun nth(n: Int): Int {
        if (n == 0) {
            throw IllegalArgumentException("There is no zeroth prime.")
        }
        if (n < 0) {
            throw IllegalArgumentException("The positive number should be given. Given: $n")
        }

        if (n <= cache.size) {
            return cache[n - 1]
        }

        for (i in biggestPrime + 1..Int.MAX_VALUE) {
            if (isPrime(i)) {
                cache.add(i)
                biggestPrime = i
                if (cache.size == n) {
                    return i
                }
            }
        }

        throw ArithmeticException("${n}th prime is too big to calculate.")
    }

    private fun isPrime(num: Int): Boolean {
        for (prime in cache) {
            if (num % prime == 0) {
                return false
            }
        }
        return true
    }
}
