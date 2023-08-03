package com.fee.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class StudentController {

    // http://localhost:9090/home/getStudent

    @GetMapping("/getStudent")
    public String userInfo() {
        System.out.println("getting students !");
        return "student";
    }


}
