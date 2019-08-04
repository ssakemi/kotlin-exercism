object HandshakeCalculator {
    private const val REVERSE_SIGNAL = 1 shl 4

    fun calculateHandshake(input: Int): List<Signal> {
        val signals = arrayListOf<Signal>()
        for (s in Signal.values()) {
            if (input and s.binary != 0) {
                signals.add(s)
            }
        }
        return if (input and REVERSE_SIGNAL == 0) signals else signals.reversed()
    }

    private val Signal.binary: Int
        get() = when (this) {
            Signal.WINK -> 1
            Signal.DOUBLE_BLINK -> 1 shl 1
            Signal.CLOSE_YOUR_EYES -> 1 shl 2
            Signal.JUMP -> 1 shl 3
        }
}
