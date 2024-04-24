object InputCheck {
    fun menuChoiceCheck(input: String, menuSize: Int): Int {
        return when (val value = input.toIntOrNull()) {
            null -> {
                println("\nВведите число цифрами!")
                -1
            }

            !in 0..menuSize -> {
                println("\nТакого числа нет. Введите положительное число, не превышающее $menuSize.")
                -1
            }

            else -> value
        }
    }

    fun checkingText(category: String): String {
        var input = readln()
        while (true) {
            if (input.isBlank()) {
                println("\n$category не может быть пустым!")
                println("Введите ${category.lowercase()}:")
                input = readln()
            } else {
                return input
            }
        }
    }
}
