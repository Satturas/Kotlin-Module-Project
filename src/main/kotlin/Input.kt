

/*class Input() {
    companion object {

        fun checkingInput(case: Int, size: Int, arch: Zip? = null): Int {
            var input: String = readln()
            while (true) {
                input = when (input.toIntOrNull()) {
                    null -> {
                        println("\nВведите число цифрами!")
                        when (case) {
                            1 -> App.mainMenu()
                            2 -> App.messageMenu(arch)
                            else -> {}
                        }
                        readln()
                    }

                    !in 0..size -> {
                        println("\nТакого числа нет. Введите положительное число, не превышающее $size.")
                        when (case) {
                            1 -> app.mainMenu()
                            2 -> app.messageMenu(arch)
                            else -> {}
                        }
                        readln()
                    }

                    else -> return input.toInt()
                }
            }
        }
    }

    private fun checkingText(category: String): String {
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

}*/