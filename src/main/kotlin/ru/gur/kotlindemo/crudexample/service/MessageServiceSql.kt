package ru.gur.kotlindemo.crudexample.service

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Service
import ru.gur.kotlindemo.crudexample.web.Message
import java.util.*

@Service
@ConditionalOnMissingBean(name = arrayOf("messageServiceRepo"))
class MessageServiceSql(val db: JdbcTemplate) : MessageService {

    /*
    The findMessages() function calls the query() function of the JdbcTemplate class. The query() function takes
    two arguments: an SQL query as a String instance, and a callback that will map one object per row:
    db.query("...", RowMapper { ... } )

    The RowMapper interface declares only one method, so it is possible to implement it via lambda expression by omitting
    the name of the interface. The Kotlin compiler knows the interface that the lambda expression needs to be converted to
    because you use it as a parameter for the function call. This is known as SAM conversion in Kotlin:
    db.query("...", { ... } )

    After the SAM conversion, the query function ends up with two arguments: a String at the first position,
    and a lambda expression at the last position. According to the Kotlin convention, if the last parameter of a function
    is a function, then a lambda expression passed as the corresponding argument can be placed outside the parentheses.
    Such syntax is also known as trailing lambda:
    db.query("...") { ... }

    _ обозначаются параметры, которые не используются в лямбде
     */
    override fun findMessages(): List<Message> = db.query("select * from messages") { response, _ ->
        Message(response.getString("id"), response.getString("text"))
    }

    override fun save(message: Message): String {
        val id = message.id ?: UUID.randomUUID().toString() //if-not-null-else
        db.update(
            "insert into messages values ( ?, ? )",
            id, message.text
        )
        return id
    }

    override fun findMessageById(id: String): List<Message> =
        db.query("select * from messages where id = '$id'") { response, _ ->
            Message(response.getString("id"), response.getString("text"))
        }
}