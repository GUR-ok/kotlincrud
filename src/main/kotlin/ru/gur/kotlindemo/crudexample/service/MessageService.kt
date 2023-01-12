package ru.gur.kotlindemo.crudexample.service

import ru.gur.kotlindemo.crudexample.web.Message

interface MessageService {

    fun findMessages(): List<Message>

    fun save(message: Message): String

    fun findMessageById(id: String): List<Message>
}