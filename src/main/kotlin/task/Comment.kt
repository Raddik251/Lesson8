package task

class Comment (
    var idComment:Int = 0,
    var idNote:Int? = null,
    var textComment:String? = null,
    var commentDelete:Boolean = false
        ) {
    override fun toString(): String {
        return "Comment(idComment=$idComment, idNote=$idNote, textComment=$textComment, commentDelete=$commentDelete)"
    }
}

