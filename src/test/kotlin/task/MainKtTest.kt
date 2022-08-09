package task

import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test(expected = NoteNotFound::class)
    fun shouldThrow() {
        //arrange
        var notes1 = Notes()

        //act
        for (startId in 1..3) {
            notes1.addNote(Note(startId, "Заметка № $startId", "Текст заметки $startId"))
        }

        notes1.getNote(5)

    }
}