import actions.ActionEnum
import java.util.Scanner

fun main() {
    val random = MyCustomList()
    val scan = Scanner(System.`in`)
    var run = true

    while (run) {
        ActionEnum.start()
        when (scan.nextInt()) {
            1 -> println("Created list: ${random.listView()}")
            2 -> println("Maximum value is ${random.getMax()}")
            3 -> println("Minimum value is ${random.getMin()}")
            4 -> println("List sorted by ascending: ${random.sortAscending()}")
            5 -> println("List sorted by descending: ${random.sortDescending()}")
            6 -> {
                print("Enter value to view it's count: ")
                when (val count = random.findValueCount(scan.nextInt())) {
                    is Int -> println("The value count is $count")
                    null -> println("This number is not in list")
                }
            }

            7 -> {
                val pair = random.mostCommonValue()
                println("The most common value is ${pair.first}, it's occurs ${pair.second} times.")
            }

            8 -> println("All numbers quantity: ${random.numbersQuantity}")
            9 -> {
                println("The program is stopped by user")
                run = false
            }
        }
    }
}