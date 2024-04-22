class InputCheck {
    companion object {
        fun menuChoiceCheck(input: String, menuSize: Int): Int {
            when (input.toIntOrNull()) {
                null -> {
                    println("\nВведите число цифрами!")
                    return -1
                }
                !in 0..menuSize -> {
                    println("\nТакого числа нет. Введите положительное число, не превышающее $menuSize.")
                    return -1
                }
                else -> return input.toInt()
            }
        }

        fun checkingText(category: String): String {
            var input = readln()
            while (true) {
                if (input == "") {
                    println("\n$category не может быть пустым!")
                    println("Введите ${category.lowercase()}:")
                    input = readln()
                } else {
                    return input
                }
            }
        }
    }
}
