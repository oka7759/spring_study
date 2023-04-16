package com.example.firstproject.api

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class FirstApiController {

    @GetMapping("/api/hello")
    fun hello():String{

        return "hello"
    }

}