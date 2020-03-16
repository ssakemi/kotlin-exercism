class ChainNotFoundException(msg: String) : RuntimeException(msg)

data class Domino(val left: Int, val right: Int)

object Dominoes {

    fun formChain(inputDominoes: List<Domino>): List<Domino> {
        if (inputDominoes.isEmpty()) {
            return inputDominoes
        }
        val chain = createChain(inputDominoes, mutableListOf()) ?: throw ChainNotFoundException("Chain not found.")
        printChain(chain)
        return chain
    }

    fun formChain(vararg inputDominoes: Domino): List<Domino> {
        return formChain(listOf(*inputDominoes))
    }

    private fun createChain(candidate: List<Domino>, permutation: MutableList<Domino>): List<Domino>? {
        if (permutation.size >= 2) {
            if (!isValid(permutation)) {
                val lastDomino = permutation.last()
                permutation[permutation.lastIndex] = Domino(lastDomino.right, lastDomino.left)
                if (!isValid(permutation)) {
                    return null
                }
            }
        }

        if (candidate.isEmpty()) {
            if (permutation.first().left == permutation.last().right) {
                return permutation
            }
            return null
        }

        for (i in 0 until candidate.size) {
            val tmpCandidate = candidate.map { it }.toMutableList()
            val tmpPermutation = permutation.map { it }.toMutableList()
            tmpPermutation.add(tmpCandidate.removeAt(i))
            val chain = createChain(tmpCandidate, tmpPermutation)
            if (chain != null) {
                return chain
            }
        }

        return null
    }

    private fun isValid(permutation: List<Domino>): Boolean {
        return permutation[permutation.lastIndex - 1].right == permutation.last().left
    }

    private fun printChain(chain: List<Domino>) {
        for (domino in chain) {
            print("${domino.left}|${domino.right}, ")
        }
        print("\n")
    }
}
