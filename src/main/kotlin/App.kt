class App {
    private val zips = mutableMapOf<Int, Zip>()

    fun start() {
        while (true) {
            mainMenu()
            val maxMenuNumber = if (zips.isEmpty()) 1 else zips.size + 1
            when (val choice = checkingInput("mainMenu", maxMenuNumber)) {
                0 -> makeZip()
                maxMenuNumber -> return
                else -> openZip(choice - 1)
            }
        }
    }

    private fun mainMenu() {
        println("\nСписок архивов:\n0. Создать архив")
        if (zips.isEmpty()) {
            println("1. Выход ")
        } else {
            for (i in zips) {
                println("${i.key + 1}. ${i.value.name}")
            }
            println("${zips.size + 1}. Выход ")
        }
    }

    private fun makeZip() {
        println("\nВведите название архива")
        val newZip =
            Zip(checkingText("Название архива"), mutableMapOf(), arrayListOf(Message("", "")))
        zips[zips.size] = newZip
    }

    private fun openZip(choice: Int) {
        println("\nАрхив \"${zips[choice]!!.name}\"")
        messageMenu(zips[choice])
    }

    private fun messageMenu(arch: Zip?) {
        while (true) {
            println("\nМеню архива:\n0. Создать заметку")
            if (arch!!.contents.isEmpty()) {
                println("1. Возврат в главное меню")
            } else {
                for (i in arch.contents) {
                    println("${i.key}. ${i.value}")
                }
                println("${arch.contents.size + 1}. Возврат в главное меню")
            }

            val maxMenuNumber = if (arch.contents.isEmpty()) 1 else arch.contents.size + 1
            when (val choice = checkingInput("messageMenu", maxMenuNumber, arch)) {
                0 -> makeMessage(arch)
                maxMenuNumber -> return
                else -> openMessage(arch, choice)
            }
        }
    }

    private fun makeMessage(arch: Zip) {
        println("\nВведите название заметки:")
        val messageName = checkingText("Название заметки")
        arch.contents[arch.contents.size + 1] = messageName
        println("\nВведите текст заметки:")
        arch.note.add(Message(messageName, checkingText("Текст заметки")))
    }

    private fun openMessage(arch: Zip, choice: Int) {
        println("\nНазвание заметки: ${arch.contents[choice]}")
        println("Текст заметки: ${arch.note[choice].content}")
        println("\nДля возврата в меню архива введите \"0\"")

        while (true) {
            if (checkingInput("other", 0, arch) == 0) {
                break
            }
        }
    }

    private fun checkingInput(case: String, size: Int, arch: Zip? = null): Int {
        var input: String = readln()
        while (true) {
            input = when (input.toIntOrNull()) {
                null -> {
                    println("\nВведите число цифрами!")
                    when (case) {
                        "mainMenu" -> mainMenu()
                        "messageMenu" -> messageMenu(arch)
                        else -> {}
                    }
                    readln()
                }
                !in 0..size -> {
                    println("\nТакого числа нет. Введите положительное число, не превышающее $size.")
                    when (case) {
                        "mainMenu" -> mainMenu()
                        "messageMenu" -> messageMenu(arch)
                        else -> {}
                    }
                    readln()
                }
                else -> return input.toInt()
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
}