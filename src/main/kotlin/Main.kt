fun main(args: Array<String>) {
    println("Добро пожаловать в приложение \"Заметки\"!")
    printChoise("архив")
    cycleIsFun("В настоящее время создано ${Container.archives.size} архивов.",
        { Container.createArchive() }, { canLook() })
}