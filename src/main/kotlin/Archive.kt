data class Archive(val name: String) {
    private val notes = mutableListOf<Note>()
    fun createNote(){
        val name = input("имя заметки")
        val content = input("содержание заметки")
        val note = Note(name, content)
        println("Заметка ${note.name} создана")
        notes.add(note)
    }
    override fun toString(): String {
        return name
    }

    fun lookNotesAndSelectAction(){
        try {
            printList(notes)
            val input = input("номер заметки").toInt() - 1
            println(notes[input].content)
            val selectedNote = notes[input]
            println("1. Дополнить заметку.")
            println("0. Выход.")
            Container.selectAction({ selectedNote.addToNote() }, { Container.printWrong() })
        } catch (e: NumberFormatException){
            println("Введите число!")
        } catch (e: IndexOutOfBoundsException){
            println("Заметки с таким номером не существует")
        }
    }
}