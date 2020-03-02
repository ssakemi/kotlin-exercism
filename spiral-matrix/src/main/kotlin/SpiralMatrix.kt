object SpiralMatrix {

    fun ofSize(size: Int): Array<IntArray> {
        var spiralMatrix = Array(size) { IntArray(size) { 0 } }
        var num = 0

        for (i in 0 until size) {
            for(k in 1..4) {
                for (j in 0 until size) {
                    if (spiralMatrix[i][j] != 0) {
                        continue
                    }
                    num++
                    spiralMatrix[i][j] = num
                }
                spiralMatrix = rotateLeft(spiralMatrix)
            }
        }
        return spiralMatrix
    }

    fun rotateLeft(input: Array<IntArray>): Array<IntArray> {
        val rotated = Array(input.size) { IntArray(input.size) { 0 } }
        for (i in 0 until input.size) {
            for (j in 0 until input.size) {
                rotated[input.size - j - 1][i] = input[i][j]
            }
        }
        return rotated
    }
}
