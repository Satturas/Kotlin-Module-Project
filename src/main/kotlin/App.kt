object App {
    private val zips = mutableMapOf<Int, Zip>()

    fun start() {
        while (true) {
            Menu.printMainMenu(zips)
            when (val madeChoice = Menu.makeChoice(zips.size + 1)) {
                -1 -> continue
                0 -> makeZip()
                zips.size + 1 -> return
                else -> zips[madeChoice - 1]?.let { zipMenu(madeChoice - 1, it) }
            }
        }
    }

    private fun makeZip() {
        println("\nВведите название архива")
        val newZip = Zip(
            InputCheck.checkingText("Название архива"),
            mutableMapOf(),
            arrayListOf(Message("", ""))
        )
        zips[zips.size] = newZip
    }

    private fun zipMenu(choice: Int, zip: Zip) {
        while (true) {
            println("\nАрхив \"${zips[choice]!!.name}\"")
            zips[choice]?.let { Menu.printZipMenu(it) }
            when (val madeChoice = Menu.makeChoice(zip.contents.size + 1)) {
                -1 -> continue
                0 -> makeMessage(zip)
                zip.contents.size + 1 -> return
                else -> messageMenu(zip, madeChoice)
            }
        }
    }

    private fun makeMessage(arch: Zip) {
        println("\nВведите название заметки:")
        val messageName = InputCheck.checkingText("Название заметки")
        arch.contents[arch.contents.size + 1] = messageName
        println("\nВведите текст заметки:")
        arch.note.add(Message(messageName, InputCheck.checkingText("Текст заметки")))
    }

    private fun messageMenu(arch: Zip, choice: Int) {
        while (true) {
            println("\nНазвание заметки: ${arch.contents[choice]}")
            Menu.printMessageMenu()
            when (Menu.makeChoice(1)) {
                -1 -> continue
                0 -> openMessage(arch, choice)
                1 -> break
            }
        }
    }

    private fun openMessage(arch: Zip, choice: Int) {
        while (true) {
            println("\nНазвание заметки: ${arch.contents[choice]}")
            println("Текст заметки: ${arch.note[choice].content}")
            println("0. Возврат в меню заметки")
            when (Menu.makeChoice(0)) {
                -1 -> continue
                0 -> break
            }
        }
    }
}