fun sum(multiplesOf: Set<Int>, upTo: Int): Int {
    var sum = 0
    for (i in 1 until upTo) {
        for (num in multiplesOf) {
            if (i % num == 0) {
                sum += i
                break
            }
        }
    }
    return sum
}