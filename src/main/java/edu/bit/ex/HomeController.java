package edu.bit.ex;

import java.security.Principal;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.catalina.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.bit.ex.vo.EmpUser;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Locale locale, Model model) {
        logger.info("Welcome home! The client locale is {}.", locale);

        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

        String formattedDate = dateFormat.format(date);

        model.addAttribute("serverTime", formattedDate);

        return "home";
    }

    @GetMapping("/login/loginForm")
    public String loginForm() {
        System.out.println("Welcom Login Form");
        return "login/loginForm";
    }

    @GetMapping("/user/userHome")
    public void userHome() {
        System.out.println("userHome");
    }

    @GetMapping("/admin/adminHome")
    public void adminHome() {
        System.out.println("adminHome");
    }

    @GetMapping("/login/accessDenied")
    public void accessDenied() {
        System.out.println("accessDenied");
    }

    @GetMapping("/loginInfo")
    public String loginInfo(Principal principal) {
        System.out.println("loginInfo");
        
        // 1. controller를 통하여 principal 객체로 가져오는 방법
        String userId = principal.getName();
        System.out.println("유저 아이디: " + principal.getName());
        
        // 2. SpringContexHolder를 통하여 가져오는 방법(일반적인 빈에서 사용 할수있음)
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        userId = auth.getName();
        System.out.println("유저 아이디: " + userId);
        
        // 3. UserDetails 갖고 오기
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        System.out.println("유저 아이디: " + userDetails.getUsername());
        
        // 4. EmpUser 꺼내오기
        EmpUser empUser = (EmpUser) auth.getPrincipal();
        System.out.println(empUser.getEmp());
        
        empUser = (EmpUser) userDetails;
        System.out.println(empUser.getEmp());
        
        // 5. User 클래스로 변환 하여 가져오는 방법
//        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        userId = user.getUsername();
//        System.out.println("유저 아이디: " + userId);
       
        return "home";
    }

}





