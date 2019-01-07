package org.totoshop.web;

import org.springframework.stereotype.Controller;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("mainController")
@Scope(scopeName = "singleton")
@RequestMapping(path = {"/"})
public class MainController{
    @RequestMapping(path = {"/index", "/index/"})
    private String main() {
        return "index";
    }
}