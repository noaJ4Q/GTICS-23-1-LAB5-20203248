package com.example.gtics231lab520203248.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping(value = {"", "/", "/index"})
    public String home(){
        return "index";
    }
}
