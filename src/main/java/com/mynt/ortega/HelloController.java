package com.mynt.ortega;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloController {

    @GetMapping("/test")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @GetMapping("/zombie")
    public String returnZombie(){
        Zombie zombie = new Zombie(5, "Brainless");
        return "Zombie has " + zombie.getTeeth() + " teeth and is " + zombie.getBrains();
    }
    @GetMapping("/money")
    public List<Cash> cashRelated(){
        List<Cash> list = new ArrayList<>();
        list.add(new Cash(4, "aaa"));
        list.add(new Cash(5, "hhh"));
        return list;

    }
}
