package by.alex.allwayticket.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/bus")
public class BusController {

    @RequestMapping
    public String bus() {

        return "bus";
    }
}
