object App {
    private val zips = mutableListOf<Zip>()

    fun start() {
        while (true) {
            Menu.printMainMenu(zips)
            when (val madeChoice = Menu.makeChoice(zips.size + 1)) {
                -1 -> continue
                0 -> makeZip()
                zips.size + 1 -> return
                else -> zipMenu(zips[madeChoice - 1])
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
        zips.add(newZip)
    }

    private fun zipMenu(zip: Zip) {
        while (true) {
            println("\nАрхив \"${zip.name}\"")
            zip.let { Menu.printZipMenu(it) }
            when (val madeChoice = Menu.makeChoice(zip.contents.size + 1)) {
                -1 -> continue
                0 -> makeMessage(zip)
                zip.contents.size + 1 -> return
                else -> messageMenu(zip, madeChoice)
            }
        }
    }

    private fun makeMessage(zip: Zip) {
        println("\nВведите название заметки:")
        val messageName = InputCheck.checkingText("Название заметки")
        zip.contents[zip.contents.size + 1] = messageName
        println("\nВведите текст заметки:")
        zip.note.add(Message(messageName, InputCheck.checkingText("Текст заметки")))
    }

    private fun messageMenu(zip: Zip, choice: Int) {
        while (true) {
            println("\nНазвание заметки: ${zip.contents[choice]}")
            Menu.printMessageMenu()
            when (Menu.makeChoice(1)) {
                -1 -> continue
                0 -> openMessage(zip, choice)
                1 -> break
            }
        }
    }

    private fun openMessage(zip: Zip, choice: Int) {
        while (true) {
            println("\nНазвание заметки: ${zip.contents[choice]}")
            println("Текст заметки: ${zip.note[choice].content}")
            println("0. Возврат в меню заметки")
            when (Menu.makeChoice(0)) {
                -1 -> continue
                0 -> break
            }
        }
    }
}