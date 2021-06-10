package edu.bit.ex.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import edu.bit.ex.service.UserService;
import edu.bit.ex.vo.UserVO;


@Controller
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @GetMapping("/user/userForm")
    public void userForm() {
        System.out.println("userForm()..");
    }
    
    @PostMapping("/user/addUser")
    public String addUser(UserVO userVO) {
        
        System.out.println("addUser()..");
        
        userService.addUser(userVO);
        
        return "redirect:/";
    }
    
	
}
