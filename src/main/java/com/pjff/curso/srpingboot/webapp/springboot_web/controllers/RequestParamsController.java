package com.pjff.curso.srpingboot.webapp.springboot_web.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pjff.curso.srpingboot.webapp.springboot_web.models.dto.ParamDto;
import com.pjff.curso.srpingboot.webapp.springboot_web.models.dto.ParamMixDto;

import jakarta.servlet.http.HttpServletRequest;

//V-26,paso 2.3, creamos el nuevo controlador
@RestController
// nuestra ruta base
@RequestMapping("/api/params")
public class RequestParamsController {

    // Paso 2.4,http://localhost:8080/api/params/foo
    @GetMapping("/foo")
    /*
     * Paso 2.7,para enviar los datos le pondremos @RequestParam
     * ponemos que el mensaje no sea requerido ,pero le damos un mensaje por defecto
     */
    public ParamDto foo(@RequestParam(required = false, defaultValue = "Hallo wir get es dir") String message) {

        // Paso 2.6,creamos su instancia.
        ParamDto param = new ParamDto();
        param.setMessage(message);
        return param;
    }

    // V-27, pasando múltiples parametros.
    @GetMapping("/bar")
    // paso 27,pasamos mas de un parámetro , con el @RequestParam
    public ParamMixDto bar(@RequestParam String text, @RequestParam Integer code) {

        ParamMixDto params = new ParamMixDto();
        params.setMessage(text);
        // paso 28, creamos un nuevo
        params.setCode(code);
        return params;
    }

    // V-28,paso 29,http://localhost:8080/api/params/request
    @GetMapping("/request")
    public ParamMixDto request(HttpServletRequest request) {
        Integer code = 10;
        try {
            // Pasamos el valor string a un entero
            code = Integer.parseInt(request.getParameter("code"));
        } catch (NumberFormatException e) {
        }
        ParamMixDto params = new ParamMixDto();
        params.setCode(code);
        params.setMessage(request.getParameter("message"));
        return params;
    }
}
