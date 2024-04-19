fun main() {
    val app = App()
    app.start()
}

class App {
    private val zips = mutableMapOf<Int, Zip>()


    fun start() {
        println("Добро пожаловать в приложение \"Заметки\"")
        zipMenu()
        when (val choice = checkingInput(zips.size)) {
            0 -> makeZip()
            zips.size -> return
            else -> openZip(choice)
        }

    }

    private fun zipMenu() {
        println("Список архивов:")
        println("0. Создать архив")
        if (zips.isEmpty()) {
            println("1. Выход ")
        } else {
            for (i in zips) {
                println("${i.key}. ${i.value}")
            }
            println("${zips.size}. Выход ")
        }
    }

    private fun makeZip() {
        println("Введите название архива")
        val zipName = checkingText("Название архива")
        val zip: ArrayList<String> = arrayListOf("")
        val newZip = Zip(zips.size - 1, zipName, zip)
        zips[zips.size] = newZip
    }

    private fun openZip(choice: Int) {
        println("Архив \"${zips[choice]}:")
    }
}

data class Zip (val number: Int, val name: String, val zip: ArrayList<String>)

fun checkingInput(size: Int): Int {
    var input: String = readln()
    while (true) {
        when (input.toIntOrNull()) {
            null -> {
                println("Введите число цифрами")
                showMenu()
                input = readln()
            }

            !in 0..size -> {
                println("Такого числа нет. Введите положительное число, не превышающее $size")
                showMenu()
                input = readln()
            }
            else -> return input.toInt()
        }
    }
}

fun showMenu() {}

fun checkingText(category: String): String {
    var input = readln()
    while (true) {
        if (input == "") {
            println("$category не может быть пустым")
            input = readln()
        } else {
            return input
        }
    }
}
