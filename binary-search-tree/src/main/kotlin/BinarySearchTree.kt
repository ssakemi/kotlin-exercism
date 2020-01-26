class BinarySearchTree<T : Comparable<T>> {

    data class Node<T>(val data: T, var left: Node<T>? = null, var right: Node<T>? = null)

    var root: Node<T>? = null

    fun insert(value: T) {
        if (root == null) {
            root = Node(value)
            return
        }
        var pos = root
        while (true) {
            if (value <= pos!!.data) {
                if (pos.left == null) {
                    pos.left = Node(value)
                    break
                }
                pos = pos.left
            } else {
                if (pos.right == null) {
                    pos.right = Node(value)
                    break
                }
                pos = pos.right
            }
        }
    }

    fun asSortedList(): List<T> {
        if (root == null) {
            return emptyList()
        }

        val sortedList = mutableListOf<T>()
        fun walk(node: Node<T>) {
            if (node.left != null) {
                walk(node.left!!)
            }
            sortedList.add(node.data)
            if (node.right != null) {
                walk(node.right!!)
            }
        }

        walk(root!!)
        return sortedList.toList()
    }

    fun asLevelOrderList(): List<T> {
        if (root == null) {
            return emptyList()
        }
        val levelOrderList = mutableListOf<T>()
        val queue = mutableListOf(root!!)
        while (queue.isNotEmpty()) {
            val node = queue.removeAt(0)
            levelOrderList.add(node.data)
            if (node.left != null) {
                queue.add(node.left!!)
            }
            if (node.right != null) {
                queue.add(node.right!!)
            }
        }
        return levelOrderList.toList()
    }

}
