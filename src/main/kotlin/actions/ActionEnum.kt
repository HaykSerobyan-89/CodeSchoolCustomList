package actions

enum class ActionEnum(val id: Int, val text: String) {
    LIST_VIEW(1, "Created list view"),
    MAX_VALUE(2, "Maximum value of list"),
    MIN_VALUE(3, "Minimum value of list"),
    SORT_ASCENDING(4, "Sort list by ascending"),
    SORT_DESCENDING(5, "Sort list by descending"),
    FIND_VALUE_COUNT(6, "Find entered value count in list"),
    MOST_COMMON_VALUE(7, "Show most common value in list"),
    ALL_NUMBERS_COUNT(8, "Show all numbers count in list"),
    EXIT(9, "Exit");

    companion object Action {
        @JvmStatic
        fun start() {
            println("----------------------------------------------")
            println("Please correctly choose action by number ! ! !")
            for (action in ActionEnum.values()) {
                println("${action.id}. ${action.text}")
            }
            println("----------------------------------------------")
        }
    }
}
