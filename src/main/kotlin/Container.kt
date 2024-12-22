object Container {
    val archives = mutableListOf<Archive>()
    fun createArchive(){
        val name = input("имя архива")
        val archive = Archive(name)
        archives.add(archive)
        println("Архив ${archive.name} создан")
    }
    fun lookContainer(){
        printList(archives)
        printChoise2()
        cycleIsFun("Список архивов: ", { inArchives() }, { printWrong() })
    }
}