package Esercizi.SpringBoot.Develhope_Spring.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Ex1InfoController {
    @GetMapping("/info")
    public ResponseEntity<String> infoResponse() {
        return ResponseEntity.ok("Ex1 Info");
    }
}
