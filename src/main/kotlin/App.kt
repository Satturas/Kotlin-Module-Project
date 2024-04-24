class App {
    private val zips = mutableMapOf<Int, Zip>()

    fun start() {
        while (true) {
            val mainMenu = Menu()
            mainMenu.printMainMenu(zips)
            val maxMenuNumber = if (zips.isEmpty()) 1 else zips.size + 1
            when (val madeChoice = mainMenu.makeChoice(maxMenuNumber)) {
                -1 -> continue
                0 -> makeZip()
                maxMenuNumber -> return
                else -> zips[madeChoice - 1]?.let { zipMenu(madeChoice - 1, it) }
            }
        }
    }

    private fun makeZip() {
        println("\nВведите название архива")
        val newZip = Zip(InputCheck.checkingText("Название архива"), mutableMapOf(), arrayListOf(Message("", "")))
        zips[zips.size] = newZip
    }

    private fun zipMenu(choice: Int, zip: Zip) {
        while (true) {
            println("\nАрхив \"${zips[choice]!!.name}\"")
            val zipMenu = Menu()
            zips[choice]?.let { zipMenu.printZipMenu(it) }
            val maxMenuNumber = if (zip.contents.isEmpty()) 1 else zip.contents.size + 1
            when (val madeChoice = zipMenu.makeChoice(maxMenuNumber)) {
                -1 -> continue
                0 -> makeMessage(zip)
                maxMenuNumber -> return
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
            val messageMenu = Menu()
            messageMenu.printMessageMenu()
            when (messageMenu.makeChoice(1)) {
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
        val openMessage = Menu()
            when (openMessage.makeChoice(0)) {
                -1 -> continue
                0 -> break
            }
        }
    }
}