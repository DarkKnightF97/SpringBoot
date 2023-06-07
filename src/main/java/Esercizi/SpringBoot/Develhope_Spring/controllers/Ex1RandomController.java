package Esercizi.SpringBoot.Develhope_Spring.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class Ex1RandomController {
    @GetMapping("/random")
    public ResponseEntity<String> randomResponse(){
        boolean randomBoolean = new Random().nextBoolean();
        if(randomBoolean){
            return ResponseEntity.ok().body("ok 200");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("bad request 400");
        }
    }
}
