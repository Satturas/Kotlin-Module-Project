import java.util.Scanner

fun main() {
    val app = App()
    app.start()
}

class App() {
    val zips = ArrayList<Zip>()


    fun start() {
        println("Добро пожаловать в приложение \"Заметки\"")
        menu()
        val input = Scanner(System.`in`).nextLine()
        while (true) {
            
        }
    }

    private fun menu() {
        println("Список архивов:")
        println("0. Создать архив")
        if (zips.isEmpty()) {
            println("1. Выход ")
        } else {
            for (i in zips) {
                println("${i.number}. ${i.name}")
            }
            println("${zips.size}. Выход ")
        }
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

fun checkingText(category: String) {
    var input: String = readln()
    while (true) {
        if (input == "") {
            println("$category не может быть пустым")
            input = readln()
        } else {
            break
        }
    }
}
