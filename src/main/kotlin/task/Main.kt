package task

    fun main () {

        var notes1 = Notes()

        val startId = 1

        for(startId in 1..3) {
            notes1.addNote(Note(startId, "Заметка № $startId", "Текст заметки $startId"),)
        }

        notes1.getNote(1)

        println("-----------------------------------------------")

        notes1.createComment(1, Comment(1, 1, "Первый коммент к заметке 1"))

        notes1.createComment(2, Comment(2, 2, "Первый коммент к заметке 2"))

        notes1.createComment(3, Comment(3, 3, "Первый коммент к заметке 3"))

        notes1.createComment(3, Comment(4, 3, "Второй коммент к заметке 3"))

        notes1.getComments(3)

        println("-----------------------------------------------")

        notes1.editNote(Note(1,"Измененная заметка №1", "Измененный текст заметки №1"))

        notes1.getNote(1)

        println("-----------------------------------------------")

        notes1.editComment(Comment(4,3,"Измененный коммент 4"))

        notes1.getComments(3)

        println("-----------------------------------------------")

        notes1.deleteNote(3)

        notes1.getComments(3) // заметка удалилась, флаг удаления у комментов поменялся

        println("-----------------------------------------------")

        notes1.editNote(Note(3,"Измененная заметка №3", "Измененный текст заметки №3"))

        notes1.getComments(3) // флаг удаления поменялся обратно

    }