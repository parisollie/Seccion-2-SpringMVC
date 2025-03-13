package com.pjff.curso.srpingboot.webapp.springboot_web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    // Vid 38,paso 48,ponemos varias rutas
    @GetMapping({ "", "/", "/home" })
    public String home() {
        // a donde quiero redirigir
        return "redirect:/list";
        // redirige a rutas
        // return "forward:/list";
    }
}
