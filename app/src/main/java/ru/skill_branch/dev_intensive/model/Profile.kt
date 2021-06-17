package ru.skill_branch.dev_intensive.model

data class Profile(
    val about:String,
    val firstName:String,
    val lastName:String,
    val repository: String,
    val rating:Int=0,
    val respect:Int=0
) {

    val nickName:String = "John Doe" // TODO implement me
    val rank:String = "Junior Android developer"

    fun toMap():Map<String,Any> = mapOf(
       "nickName" to nickName,
       "rank" to rank,
       "firstname" to firstName,
       "lastname" to lastName,
       "rating" to rating,
       "respect" to respect
    )
}