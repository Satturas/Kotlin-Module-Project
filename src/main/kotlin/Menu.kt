object Menu {

    fun printMainMenu(zips: Map<Int, Zip>) {
        println("\nСписок архивов:\n0. Создать архив")
        for (i in zips) {
            println("${i.key + 1}. ${i.value.name}")
        }
        println("${zips.size + 1}. Выход ")
    }

    fun printZipMenu(zip: Zip) {
        println("\nСписок заметок:\n0. Создать заметку")
        for (i in zip.contents) {
            println("${i.key}. ${i.value}")
        }
        println("${zip.contents.size + 1}. Возврат в главное меню")
    }

    fun printMessageMenu() = println("0. Просмотр заметки\n1. Возврат в меню архива")

    fun makeChoice(maxMenuNumber: Int): Int = InputCheck.menuChoiceCheck(readln(), maxMenuNumber)

}