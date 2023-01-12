package ru.gur.kotlindemo.crudexample.web

import org.springframework.web.bind.annotation.*
import ru.gur.kotlindemo.crudexample.service.MessageService

@RestController
class MessageController(val service: MessageService) {

    @GetMapping("/")
    //фигурные скобки опущены, т.к. функция из одного expression
    fun index(@RequestParam("name") name: String) =
        "Hello, $name!" //нет возвращаемого типа, берется сразу из выражения компилятором

    @GetMapping("/message")
    //фигурные скобки опущены, т.к. функция из одного expression
    fun index() = listOf(
        Message(null, "firstMsg"),
        Message(null, "secondMsg"),
        Message("idTest", "thirdMsg"), //запятая на конце допускается
    )

    @GetMapping("/messages")
    fun getMessages(): List<Message> = service.findMessages()

    @PostMapping("/message")
    fun createMessage(@RequestBody message: Message) =
        service.save(message)
}