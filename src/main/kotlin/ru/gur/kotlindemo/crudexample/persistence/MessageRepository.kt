package ru.gur.kotlindemo.crudexample.persistence

import org.springframework.data.repository.CrudRepository
import ru.gur.kotlindemo.crudexample.web.Message

interface MessageRepository : CrudRepository<Message, String>