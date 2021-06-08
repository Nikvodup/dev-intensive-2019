package ru.skill_branch.dev_intensive.extensions

import ru.skill_branch.dev_intensive.model.User
import ru.skill_branch.dev_intensive.model.UserView
import ru.skill_branch.dev_intensive.utils.Utils
import java.util.*

fun User.toUserView(): UserView{
    val nickName = Utils.transliteration("$firstName $lastName")
    val status = if(lastVisit==null) "Ни разу не был" else if(isOnLine) "online" else ("Последний раз был ${lastVisit.humanizeDiff()}")
    var initials = Utils.toInitials(firstName, lastName)

        return UserView(
             id,
            fullName ="$firstName $lastName",
             avatar = avatar,
            nickName = nickName ,
               status = status ,
            initials = initials
        )
}

