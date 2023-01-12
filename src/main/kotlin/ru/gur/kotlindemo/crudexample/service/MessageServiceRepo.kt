package ru.gur.kotlindemo.crudexample.service

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.stereotype.Service
import ru.gur.kotlindemo.crudexample.persistence.MessageRepository
import ru.gur.kotlindemo.crudexample.web.Message
import java.util.*

@Service
@ConditionalOnProperty(value = arrayOf("app.springdata.enabled"), havingValue = "true", matchIfMissing = false)
class MessageServiceRepo(val repository: MessageRepository) : MessageService {

    override fun findMessages(): List<Message> = repository.findAll().toList()

    override fun save(message: Message): String =
        repository.save(message).id ?: throw RuntimeException()

    override fun findMessageById(id: String): List<Message> = repository.findById(id).toList()

    fun <T : Any> Optional<out T>.toList(): List<T> =
        if (isPresent) listOf(get()) else emptyList()
}