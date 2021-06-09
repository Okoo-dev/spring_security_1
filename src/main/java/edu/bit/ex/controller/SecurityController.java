package edu.bit.ex.controller;


import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    
    @GetMapping("/admin")
    public void doAdmin() {
        System.out.println("logined admin");
    }
    
    @GetMapping("/accessError")
    public void accessError(Authentication auth, Principal pi ,  Model model) {
        
        System.out.println("accessError().."+ auth);
        model.addAttribute("msg","AccessError");
    }
	
}
