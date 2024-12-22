data class Archive(val name: String) {
    val notes = mutableListOf<Note>()
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
}