data class Note(val name: String, var content: String){
    override fun toString(): String {
        return name
    }

    fun addToNote(){
        val addedText = input("текст")
        content += addedText
    }
}