package ru.gur.kotlindemo.crudexample

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CrudexampleApplication

fun main(args: Array<String>) {
	runApplication<CrudexampleApplication>(*args) //*args означает передачу массива как varargs
}
