package by.alex.allwayticket.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/air")
public class AirController {

    @RequestMapping
    public String air(){
        return "air";
    }
}

