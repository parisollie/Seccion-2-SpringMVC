package com.pjff.curso.srpingboot.webapp.springboot_web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    // Vid 38,paso 2.45,ponemos varias rutas
    @GetMapping({ "", "/", "/home" })
    public String home() {
        // a donde quiero redirigir
        return "redirect:/list";
        // redirige a rutas
        // return "forward:/list";
    }
}

/*
 * Forward VS Redirect
 * 
 * La diferencia es que con el forward se mantiene dentro de la misma
 * peticion http , y no pierdes los parámetros que tienes dentro del request
 * ,tampoco cambia la ruta url,ya que no hace un refresh(refresh de la
 * página),sino que despacha a otra accion del controlador pero sin recargar la
 * página,mientras que el redirect cambia la ruta url , reinicia el request y
 * refresca el navegador, además que todos los parámetros del request que
 * teníamos antes del redirect se pierden en este nuevo request.
 */