fun input(name: String): String {
    println("Введите $name")
    val result = readln()
    return result
}
fun printChoise(created: String){
    println("Выберите действие:")
    println("1. Создать $created")
    println("2. Посмотреть список существующих")
    println("0. Выход")
}
fun printChoise2(){
    println("Выберите действие: ")
    println("1. Выбрать архив")
    println("0. Выход")
}

fun <T>printList(list: MutableList<T>) = list.forEachIndexed { index, element -> println("${index + 1}. $element") }

fun cycleIsFun(fun1:() -> Unit, fun2:() -> Unit){
    while(true){
        when(input("номер команды")){
            "1" -> fun1()
            "2" -> fun2()
            "0" -> return
            else -> printWrong()
        }
    }
}


fun isInSize(arch: Archive){
        val input = input("номер заметки").toInt() - 1
        if(input in 0 until arch.notes.size)
            println(arch.notes[input].content)
        else println("Заметки с таким номером не существует")
}
fun printWrong() = println("Неизвестная команда!")

fun canLook(){
    if(Container.archives.isNotEmpty()){
        Container.lookContainer()
    } else println("Нет существующих архивов!")
}

fun inArchives(){
    val input = input("номер архива").toInt() - 1
    if(input in 0 until  Container.archives.size) {
        val selectedArchive = Container.archives[input]
        printChoise("заметку")
        cycleIsFun({ selectedArchive.createNote() }, { isInSize(selectedArchive) })
    }
}