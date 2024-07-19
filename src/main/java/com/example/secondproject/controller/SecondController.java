package com.example.secondproject.controller;

import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SecondController {
    @GetMapping("/hi")
    public String niceToMeetYou(Model model){
        // model 객체가 "예찬" 값을 "username"에 연결해 웹 브라우저로 보냄
        model.addAttribute("username","예찬");
        return "greetings"; // greetings.mustache 파일 반환
    }
    @GetMapping("/bye")
    public String seeYouNext(Model model){
        model.addAttribute("nickname","안예찬");
        return "goodbye";
    }

}
