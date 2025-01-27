package kz.aitu.restpro2422.restpro.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @GetMapping("/main")
    public String myListener() {
        return "Hello World";
    }
}
