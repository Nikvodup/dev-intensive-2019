package ru.skill_branch.dev_intensive.model

import ru.skill_branch.dev_intensive.utils.Utils
import java.util.*

data class User(
    val id:String,
    val firstName: String?,
    val lastName:String?,
    var avatar:String?,
  //  val initials:MutableList<String>,
    var rating:Int=0,
    var respect:Int=0,
    val lastVisit: Date?=null,
    val isOnLine:Boolean=false

) {



    constructor(id: String, firstName: String?, lastName: String?) : this (id, firstName, lastName, null)

    constructor(id: String) : this (id,"John","Doe $id")

    init {
        println("It's Alive!!!\n" +
               "${if(lastName==="Doe") "His name is $firstName $lastName"
               else if(firstName.isNullOrEmpty()||lastName.isNullOrEmpty()) "And his name is Adam Smith!!!"
               else "And his name is $firstName $lastName"}\n") }





    companion object Factory{
        private var lastId:Int=-1
      fun makeUser(fullName:String?) : User{
          lastId++

          val (firstName, lastName) = Utils.parseFullName(fullName)
          return  User(id ="$lastId", firstName = firstName, lastName = lastName)
          }



    }



    }

   /**  private fun getIntro()="""
        
        tu tu tu ru tuuuuu!!!!!
        tu tu tu ru tuuuuuuuuu!!!
        
         tu tu tu ru tuuuuu!!!!!
        tu tu tu ru tuuuuuuuuu!!!  
            ${"\n\n\n"}
         $firstName $lastName        
    """.trimIndent()  **/

 /**   fun printMe()=println("""
            id: $id
            firstName: $firstName
            lastName: $lastName
            avatar: $avatar
            rating: $rating
            respect: $respect            
            lastVisit: $lastVisit
            isOnLine: $isOnLine
       """
        )
    } **/


