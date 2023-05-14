package com.example.Firstproject.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {
    @GetMapping("/hi")
    public String Hello(Model model){
        model.addAttribute("username" , "주쿤이");
        return "greetings";     //templates//greetings.mustache 인 브라우저로 전송
    }

    @GetMapping("/bye")
    public String seeyou(Model model) {
        model.addAttribute("nickname","주바");

        return "goodbye";
    }

}
