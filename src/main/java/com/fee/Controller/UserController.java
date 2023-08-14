package com.fee.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class UserController {

    // http://localhost:9090/home/getStudent

    @GetMapping("/getUser")
    public String userInfo() {
        System.out.println("getting students !");
        return "student";
    }


}
