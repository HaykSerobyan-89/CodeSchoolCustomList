import kotlin.random.Random

class MyCustomList(var length: Int = 20, var minValue: Int = -1000, var maxValue: Int = 1000) {
    private val randomValues = Array(length) { Random.nextInt(minValue, maxValue) }
    val numbersQuantity = HashMap<Int, Int>()

    init {
        for (number in randomValues) {
            if (numbersQuantity[number] == null) {
                numbersQuantity[number] = 1
            } else {
                numbersQuantity[number] = numbersQuantity[number]!! + 1
            }
        }
    }

    fun listView(): String {
        return randomValues.joinToString(separator = ", ", prefix = "[ ", postfix = " ]")
    }

    fun getMax(): Int {
        var max = randomValues[0]
        for (number in randomValues) {
            if (number > max) {
                max = number
            }
        }
        return max
    }

    fun getMin(): Int {
        var min = randomValues[0]
        for (number in randomValues) {
            if (number < min) {
                min = number
            }
        }
        return min
    }

    fun sortAscending(): String {
        // selection sort
        val arr = randomValues.clone()
        val n = this.length
        var temp: Int
        for (i in 0 until n) {
            var indexOfMin = i
            for (j in n - 1 downTo i) {
                if (arr[j] < arr[indexOfMin])
                    indexOfMin = j
            }
            if (i != indexOfMin) {
                temp = arr[i]
                arr[i] = arr[indexOfMin]
                arr[indexOfMin] = temp
            }
        }
        return arr.joinToString(separator = ", ", prefix = "[ ", postfix = " ]")

    }

    fun sortDescending(): String {
        // bubble sort
        val arr = randomValues.clone()
        var swap = true
        while (swap) {
            swap = false
            for (i in 0 until arr.size - 1) {
                if (arr[i] < arr[i + 1]) {
                    val temp = arr[i]
                    arr[i] = arr[i + 1]
                    arr[i + 1] = temp
                    swap = true
                }
            }
        }
        return arr.joinToString(separator = ", ", prefix = "[ ", postfix = " ]")
    }

    fun findValueCount(value: Int): Int? {
        return numbersQuantity[value]
    }

    fun mostCommonValue(): Pair<Int, Int> {
        val result = numbersQuantity.toList().sortedBy { (_, value) -> value }.reversed()
        return result[0]
    }

}

