package ru.skill_branch.dev_intensive.model

class Chat (
    val id:String,
    val members:MutableList<User> = mutableListOf(),
    val messages:MutableList<BaseMessage> = mutableListOf()
        ){
}