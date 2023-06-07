package Esercizi.SpringBoot.Develhope_Spring.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class Ex1GreetingController {

    @GetMapping("/hello")
    public String helloResponse(){
        return "hello Spring!" ;
    }

    @GetMapping("/greeting")
    public ResponseEntity<String> greetingResponse(){
        return ResponseEntity.ok("Good Afternoon!");
    }


}
