class Triangle(
    val side1: Number,
    val side2: Number,
    val side3: Number
) {
    init {
        if (side1.toDouble() <= 0 || side2.toDouble() <= 0 || side3.toDouble() <= 0) {
            throw IllegalArgumentException("all sides have to be of length > 0")
        }
        if (side1.toDouble() + side2.toDouble() < side3.toDouble() || side1.toDouble() + side3.toDouble() < side2.toDouble() || side2.toDouble() + side3.toDouble() < side1.toDouble()) {
            throw IllegalArgumentException(" the sum of the lengths of any two sides must be greater than or equal to the length of the third side")
        }
    }

    val isEquilateral: Boolean = side1 == side2 && side2 == side3
    val isIsosceles: Boolean = side1 == side2 || side2 == side3 || side1 == side3
    val isScalene: Boolean = !(isEquilateral || isIsosceles)
}