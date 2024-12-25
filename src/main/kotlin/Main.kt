fun main(args: Array<String>) {
    println("Добро пожаловать в приложение \"Заметки\"!")
    Container.printChoise("архив")
    Container.selectAction({ Container.createArchive() }, { Container.canLook() })
}