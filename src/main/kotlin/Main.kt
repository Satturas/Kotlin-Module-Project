fun main() {
    println("Добро пожаловать в приложение \"Заметки\"!")
    val app = App()
    app.start()
}

class App {
    private val zips = mutableMapOf<Int, Zip>()


    fun start() {
        while (true) {
            zipMenu()
            val maxMenuNumber = if (zips.isEmpty()) 1 else zips.size + 1
            when (val choice = checkingInput(1, maxMenuNumber)) {
                0 -> makeZip()
                maxMenuNumber -> return
                else -> {
                    openZip(choice - 1)
                }
            }
        }
    }

    private fun makeZip() {
        println("\nВведите название архива")
        val zipName = checkingText("Название архива")
        val zip: MutableMap<Int, String> = mutableMapOf()
        val array = arrayListOf<Mess>()
        val mess = Mess("","")
        array.add(mess)
        val newZip = Zip(zipName, zip, array)
        zips[zips.size] = newZip


    }

    private fun zipMenu() {
        println("\nСписок архивов:")
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
        while (true) {
            println("\nМеню архива:")
            println("0. Создать заметку")
            if (arch!!.contents.isEmpty()) {
                println("1. Выход ")
            } else {
                for (i in arch.contents) {
                    println("${i.key}. ${i.value}")
                }
                println("${arch.contents.size + 1}. Выход ")
            }
            val maxMenuNumber = if (arch.contents.isEmpty()) 1 else arch.contents.size + 1
            when (val choice = checkingInput(2, maxMenuNumber, arch)) {
                0 -> {
                    makeMessage(arch)
                }

                maxMenuNumber -> return
                else -> {
                    openMessage(arch, choice)
                }
            }
        }
    }

    private fun makeMessage(arch: Zip?) {
        println("\nВведите название заметки")
        val messageName = checkingText("Название заметки")
        println("\nВведите текст заметки")
        val textName = checkingText("Текст заметки")
        //val message: MutableMap<Int, String> = mutableMapOf()
        //message[messages.size] = textName
        val newMessage = Message(messageName, textName)
        arch!!.contents[arch.contents.size + 1] = messageName
        val newMess = Mess(messageName, textName)
        arch.note.add(newMess)
    }

    private fun openMessage(arch: Zip?, choice: Int) {
        println("\nНазвание заметки: ${arch!!.contents[choice]}")
        println("Текст заметки: ${arch.note[choice].content}")
        println("\nДля возврата введите \"0\"")
        while (true) {
            if (checkingInput(3, 0, arch) == 0) {
                break
            }
        }
    }



    private fun openZip(choice: Int) {
        println("\nАрхив \"${zips[choice]!!.name}\"")
        messageMenu(zips[choice])
    }


    private fun checkingInput(case: Int, size: Int, arch: Zip? = null): Int {
        var input: String = readln()
        while (true) {
            input = when (input.toIntOrNull()) {
                null -> {
                    println("\nВведите число цифрами!")
                    when (case) {
                        1 -> zipMenu()
                        2 -> messageMenu(arch)
                        else -> {}
                    }
                    readln()
                }

                !in 0..size -> {
                    println("\nТакого числа нет. Введите положительное число, не превышающее $size.")
                    when (case) {
                        1 -> zipMenu()
                        2 -> messageMenu(arch)
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
