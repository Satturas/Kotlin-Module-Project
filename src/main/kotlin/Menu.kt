class Menu {

    fun printMainMenu(zips: Map<Int, Zip>) {
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

    fun printZipMenu(zip: Zip) {
        println("\nСписок заметок:\n0. Создать заметку")
        if (zip.contents.isEmpty()) {
            println("1. Возврат в главное меню ")
        } else {
            for (i in zip.contents) {
                println("${i.key}. ${i.value}")
            }
            println("${zip.contents.size + 1}. Возврат в главное меню")
        }
    }

    fun printMessageMenu() {
        println("0. Просмотр заметки")
        println("1. Возврат в меню архива")
    }

    fun makeChoice(maxMenuNumber: Int): Int {
        while (true) {
            val checkedChoice = InputCheck.menuChoiceCheck(readln(), maxMenuNumber)
            return checkedChoice
        }
    }
}
