fun input(name: String): String {
    while (true) {
        println("Введите $name")
        val result = readln()
        if (result.isEmpty()) {
            println("Ввод не может быть пустым!")
            continue
        }
        return result
    }
}

fun <T>printList(list: MutableList<T>) = list.forEachIndexed { index, element -> println("${index + 1}. $element") }