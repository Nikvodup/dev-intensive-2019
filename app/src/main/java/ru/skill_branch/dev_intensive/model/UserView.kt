package ru.skill_branch.dev_intensive.model

class UserView (
  val  id:String,
  val fullName:String,
  val nickName:String,
  var status:String?="offline",
  var avatar:String?=null,
  var initials:MutableList<String>?
){
  fun printMe(){
    println("""
      id: $id
      fullName:$fullName:
      nickName:$nickName:
      avatar:$avatar:
      status:$status:
      initials:$initials:
    """.trimIndent()
    )
  }
}


