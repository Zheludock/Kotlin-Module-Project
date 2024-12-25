object Container {
    private val archives = mutableListOf<Archive>()
    fun createArchive(){
        val name = input("имя архива")
        val archive = Archive(name)
        archives.add(archive)
        println("Архив ${archive.name} создан")
    }
    private fun lookAllArchivesAndSelectAction(){
        printList(archives)
        printChoise2()
        selectAction({ inArchives() }, { printWrong() })
    }
    fun selectAction(fun1:() -> Unit, fun2:() -> Unit){
        while(true){
            when(input("номер команды")){
                "1" -> fun1()
                "2" -> fun2()
                "0" -> return
                else -> printWrong()
            }
        }
    }
    private fun inArchives(){
        try {
            val input = input("номер архива").toInt() - 1
            val selectedArchive = archives[input]
            printChoise("заметку")
            selectAction({ selectedArchive.createNote() }, { selectedArchive.lookNotesAndSelectAction() })
        } catch (e: NumberFormatException) { println("Введите число") }
        catch (e: IndexOutOfBoundsException){ println("Архива с таким индексом не существует!") }
    }
    fun canLook(){
        if(archives.isNotEmpty()){
            lookAllArchivesAndSelectAction()
        } else println("Нет существующих архивов!")
    }

    fun printChoise(created: String){
        println("Выберите действие:")
        println("0. Выход")
        println("1. Создать $created")
        println("2. Посмотреть список существующих")
    }

    private fun printChoise2(){
        println("Выберите действие: ")
        println("0. Выход")
        println("1. Выбрать архив")
    }

    fun printWrong() = println("Неизвестная команда!")
}