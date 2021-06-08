package edu.bit.ex.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/security/*")
@Controller
public class SecurityController {
    
    @GetMapping("/all")
    public void doAll() {
        System.out.println("do all can access everybody");
    }
    
    @GetMapping("/member")
    public void doMember() {
        System.out.println("logined member");
    }
	
}
