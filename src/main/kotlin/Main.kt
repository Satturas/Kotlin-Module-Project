fun main() {
    val app = App()
    app.start()
}

class App {
    private val zips = mutableMapOf<Int, Zip>()
    private val messages = mutableMapOf<Zip, Message>()

    fun start() {
        println("Добро пожаловать в приложение \"Заметки\"")
        while (true) {
            zipMenu()
            val maxMenuNumber = if (zips.isEmpty()) 1 else zips.size + 1
            when (val choice = checkingInput(maxMenuNumber)) {
                0 -> makeZip()
                maxMenuNumber -> return
                else -> openZip(choice - 1)
            }
        }
    }

    private fun zipMenu() {
        println("Список архивов:")
        println("0. Создать архив")
        if (zips.isEmpty()) {
            println("1. Выход ")
        } else {
            for (i in zips) {
                println("${i.key + 1}. ${i.value.name}")
            }
            println("${zips.size + 1}. Выход ")
        }
    }

    private fun messageMenu(arch: Zip?) {
        println("Список заметок:")
        println("0. Создать заметку")
        if (arch!!.contents.isEmpty()) {
            println("1. Выход ")
        } else {
            for (i in arch.contents) {
                println("${i.key}. ${i.value}")
            }
            println("${zips.size}. Выход ")
        }

        while (true) {
            val maxMenuNumber = if (arch.contents.isEmpty()) 1 else arch.contents.size + 1
            when (val choice = checkingInput(maxMenuNumber)) {
                0 -> makeMessage(arch)
                maxMenuNumber -> break
                else -> openMessage(choice - 1)
            }
        }
    }

    private fun makeMessage(arch: Zip?) {
        println("Введите название заметки")
        val messageName = checkingText("Название заметки")
        println("Введите текст заметки")
        val textName = checkingText("Текст заметки")
        val message: MutableMap<Int, String> = mutableMapOf()
        message[messages.size] = messageName
        val newMessage = Message(messageName, message, textName)
        messages[arch!!] = newMessage
    }

    private fun openMessage(choice: Int) {

    }

    private fun makeZip() {
        println("Введите название архива")
        val zipName = checkingText("Название архива")
        val zip: MutableMap<Int, String> = mutableMapOf()
        val newZip = Zip(zipName, zip)
        zips[zips.size] = newZip
    }

    private fun openZip(choice: Int) {
        println("Архив \"${zips[choice]!!.name}\":")
        messageMenu(zips[choice])

    }
}

fun checkingInput(size: Int): Int {
    var input: String = readln()
    while (true) {
        input = when (input.toIntOrNull()) {
            null -> {
                println("Введите число цифрами")
                showMenu()
                readln()
            }

            !in 0..size -> {
                println("Такого числа нет. Введите положительное число, не превышающее $size")
                showMenu()
                readln()
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
