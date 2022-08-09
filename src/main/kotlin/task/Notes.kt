package task

class Notes {

    var notes = mutableListOf(Note<String>(textNote = "Пустая заметка"))

    var comments = mutableListOf(Comment())

    fun getNote (idNoteIn: Int): Boolean {
        for (note in notes) {
            if (note.idNote === idNoteIn && !note.noteDelete) {
                println(note.toString())
                return true
            }
        }
        return throw NoteNotFound("Заметка не найдена или удалена")
    }

    fun getComments (idNoteIn: Int): Boolean {
        var flag = false
        for (comment in comments) {
            if (comment.idNote === idNoteIn) {
                println(comment.toString())
                flag = true
            }
        }
        return if(flag) true else throw NoteNotFound("Комментарии к заметке или заметка не найдены")
    }

    fun addNote(noteIn: Note<String>): Int {
        notes += noteIn
        return noteIn.idNote
    }

    fun deleteNote(idNoteIn: Int): Boolean {
        for (note in notes) {
            if (note.idNote === idNoteIn) {
                note.noteDelete = true
                deleteCommentFromNote(idNoteIn)
                return true
            }
        }
        return throw NoteNotFound("Заметка не найдена")
    }

    private fun deleteCommentFromNote (idNoteIn: Int) {
        for (comment in comments) {
            if (comment.idNote === idNoteIn) {
                comment.commentDelete = true
            }
        }
    }

    fun editNote(noteIn: Note<String>): Boolean {
        for (note in notes) {
            if (note.idNote === noteIn.idNote) {
                note.title = noteIn.title
                note.textNote = noteIn.textNote
                note.noteDelete = noteIn.noteDelete
                //поскольку нет смысла редактировать удаленную заметку,
                // любое редактирование заметки восстанавливает ее, если она была удалена
                recoverCommentFromNote(noteIn.idNote)
                return true
            }
        }
        return throw NoteNotFoundOrDeleteException("Заметка не найдена или была удалена")
    }

    private fun recoverCommentFromNote (idNoteIn: Int) {
        for (comment in comments) {
            if (comment.idNote === idNoteIn) {
                comment.commentDelete = false
            }
        }
    }

    fun createComment(idNoteIn: Int, commentIn: Comment): Boolean {
        for (note in notes) {
            if (note.idNote === idNoteIn && !note.noteDelete) {
                comments += commentIn
                return true
            }
        }
        return throw NoteNotFoundOrDeleteException("Заметка не найдена или была удалена")
    }

    fun deleteComment(idCommentInt: Int): Boolean {
        for (comment in comments) {
            if (comment.idComment === idCommentInt) {
                comment.commentDelete = true
                return true
            }
        }
        return throw CommentNotFound("Комментарий не найден")
    }

    fun editComment(commentIn: Comment): Boolean {
        for (comment in comments) {
            if (comment.idComment === commentIn.idComment && !comment.commentDelete) {
                comment.textComment = commentIn.textComment
                return true
            }
        }
        return throw CommentNotFoundOrDelete("Комментарий не найден или был удален")
    }
}

class NoteNotFound(a: String) : Exception(a)

class NoteNotFoundOrDeleteException(b: String) : Exception(b)

class CommentNotFound(c: String) : Exception(c)

class CommentNotFoundOrDelete(d: String) : Exception(d)
