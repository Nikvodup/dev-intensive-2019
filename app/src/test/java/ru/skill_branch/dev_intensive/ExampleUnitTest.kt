package ru.skill_branch.dev_intensive

import org.junit.Test

import org.junit.Assert.*
import ru.skill_branch.dev_intensive.extensions.*
import ru.skill_branch.dev_intensive.model.*
import java.util.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun test_instanse(){
  /**      val user = User("1")
        val user2 = User("2", "John" ,"Wick")
        val user3 = User("3", "John", "Silverhand", avatar = null, lastVisit = Date(), isOnLine = true)

        user.printMe()
        user2.printMe()
        user3.printMe()

        println("$user $user2 $user3") **/

       //val user2 =User("2","John", "Cena")

    }

    @Test
   fun  test_factory(){
    //   val user = User.makeUser("John Cena")
    //    val user2 = User.makeUser("John Wick")
        val user = User.makeUser("John Wick")
       // val user2 = user.copy(id="2",lastName="Cena", lastVisit= Date())

       // print("$user \n $user2")
    }

    @Test
    fun test_decomposition(){
        val user = User.makeUser("John Wick")

        fun getUserInfo() = user
        val (id, firstName, lastName) = getUserInfo()

        println("$id, $firstName, $lastName")
        println("${user.component1()}, $firstName, $lastName")

    }

    @Test
    fun test_copy(){
        val user = User.makeUser("John Wick")
        var user2 = user.copy( lastVisit = Date().add(-2, TimeUnits.SECOND))
        var user3 = user.copy(lastName = "Cena", lastVisit = Date().add(2,TimeUnits.HOUR))

        println("""
            ${user.lastVisit?.format()}
            ${user2.lastVisit?.format()}
            ${user3.lastVisit?.format()}
        """.trimIndent())
    }


    @Test
    fun test_data_mapping(){
        val user = User.makeUser("Яша Долгополов")
        val newUser = user.copy(lastVisit = Date().add(-4,TimeUnits.DAY))
        println(user)

      var  userView = user.toUserView()
        userView.printMe()
    }

    @Test
    fun test_abstract_factory(){
        val user = User.makeUser("Alex Nick")
        val txtMessage = BaseMessage.makeMessage(user, Chat("0"),payload = "any text", type = "text")
        val imgMessage = BaseMessage.makeMessage(user, Chat("0"),payload = "any image url", type = "image")

        when(txtMessage){
            is TextMessage -> println("text message")
            is ImageMessage -> println("image message")
        }

        txtMessage.formatMessage()
        imgMessage.formatMessage()
    }
}