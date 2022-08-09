package task

class Note <A>(
    var idNote: Int = 0,
    var title: String = "Пустая заметка",
    var textNote: A,
    var noteDelete: Boolean = false,
) {
    override fun toString(): String {
        return "Note(idNote=$idNote, title='$title', textNote=$textNote, noteDelete=$noteDelete)"
    }
}