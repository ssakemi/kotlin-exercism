import java.lang.IllegalArgumentException

object PascalsTriangle {

    @Throws(IllegalArgumentException::class)
    fun computeTriangle(rows: Int): List<List<Int>> {
        if(rows < 0) throw IllegalArgumentException("Row(s) should be 0 or positive number: $rows")
        if(rows == 0) return emptyList()

        fun generateNextRow(row: List<Int>): List<Int> {
            val nextRow = mutableListOf(1,1)
            for(i in 0 until row.size - 1) {
                nextRow.add(i+1, row[i] + row[i+1])
            }
            return nextRow.toList()
        }

        val triangle = mutableListOf<List<Int>>()
        var row = listOf(1)
        for(i in 0 until rows) {
            triangle.add(row)
            row = generateNextRow(row)
        }
        return triangle.toList()
    }
}
