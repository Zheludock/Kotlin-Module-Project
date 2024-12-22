fun main(args: Array<String>) {
    println("Добро пожаловать в приложение \"Заметки\"!")
    printChoise("архив")
    cycleIsFun({ Container.createArchive() }, { canLook() })
}