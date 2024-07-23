package com.springboot.example.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class helloController {
    @RequestMapping("/")
    public String index() {
        return "index";
    }
    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }
    @RequestMapping("/greeting")
    public String greeting(@RequestParam(name = "data", required = false, defaultValue = "World!") String data, Model model) {
        model.addAttribute("data",data);
        return "greeting";
    }
    @RequestMapping("/user")
    public String user(@RequestParam(name="name", required = true, defaultValue = "error") String userName, Model model) {
        model.addAttribute("name",userName);
        if(userName.equals("error")) {
            return "error";
        }
        return "user";
    }
    @RequestMapping("/new")
    public String add() {
        return "new";
    }
    @PostMapping("/user")
    public String postUser(@RequestParam(name="name", defaultValue = "error") String userName, Model model) {
        model.addAttribute("name",userName);
        if(userName.equals("error")) {
            return "error";
        }
        return "user";
    }
}
