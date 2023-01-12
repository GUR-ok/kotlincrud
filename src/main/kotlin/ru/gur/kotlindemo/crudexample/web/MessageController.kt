package ru.gur.kotlindemo.crudexample.web

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class MessageController {

    @GetMapping("/") //фигурные скобки опущены, т.к. функция из одного expression
    fun index(@RequestParam("name") name: String) = "Hello, $name!" //нет возвращаемого типа, берется сразу из выражения компилятором
}