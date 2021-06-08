package ru.skill_branch.dev_intensive.model

import java.util.*

abstract class BaseMessage(
    val id:String,
    val from:User?,
    val chat:Chat,
    val isIncoming:Boolean=false,
    val date:Date = Date()

) {

}