package ru.skill_branch.dev_intensive.model

import ru.skill_branch.dev_intensive.extensions.humanizeDiff
import java.util.*

class ImageMessage(
    id:String,
    from:User?,
    chat:Chat,
    isIncomming:Boolean = false,
    date: Date = Date(),
    var image:String?
) : BaseMessage(id,from,chat,isIncomming,date) {
    override fun formatMessage():String ="id:$id, ${from?.firstName}, ${if(isIncoming) "получил" else "отправил"}" +
            " сообщение \"$image\" ${date.humanizeDiff()}"


}