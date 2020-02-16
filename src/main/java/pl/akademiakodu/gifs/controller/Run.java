package pl.akademiakodu.gifs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Run {
    @GetMapping("/")
    @ResponseBody
    public String hello () {

        return "Dziala";
    }
}
