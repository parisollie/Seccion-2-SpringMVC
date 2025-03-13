package com.pjff.curso.srpingboot.webapp.springboot_web.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pjff.curso.srpingboot.webapp.springboot_web.models.User;
import com.pjff.curso.srpingboot.webapp.springboot_web.models.dto.ParamDto;

//Vid 29,paso 30,para enviar parámetros a nuestra ruta.
@RestController
@RequestMapping("/api/var")
public class PathVariableController {

    // Vid 32
    // Vid 33,paso 35 ,inyectamos configuraciones. con ("${config.username}") y el
    // nombre que pusimos en el archivo
    // properties
    @Value("${config.username}")
    private String username;

    @Value("${config.listOfValues}")
    // Vid 35,paso 40 ,pasamos una lista
    private List<String> listOfValues;

    @Value("${config.code}")
    private Integer code;

    // Paso 41, lenguaje de expresiones #{},split para convertir en un arreglo
    // # es un lenguaje de expresion
    @Value("#{'${config.listOfValues}'.toUpperCase().split(',')}")
    private List<String> valueList;

    @Value("#{'${config.listOfValues}'.toUpperCase()}")
    private String valueString;

    // Vid 36,paso 42
    @Value("#{${config.valuesMap}}")
    private Map<String, Object> valuesMap;

    @Value("#{${config.valuesMap}.product}")
    private String product;

    @Value("#{${config.valuesMap}.price}")
    private Long price;

    /*
     * Vid 37,paso 43, autocableado ,sistema de inyeccion , lo que hace buscar un
     * compoenente de spring en su contenedor
     */
    @Autowired
    private Environment environment;

    // Vid 29,paso 31
    // http://localhost:8080/api/var/baz/hello
    @GetMapping("/baz/{message}")
    // para capturar el parametro que varía ponemos @PathVariable String message
    public ParamDto baz(@PathVariable String message) {

        ParamDto param = new ParamDto();
        param.setMessage(message);
        return param;
    }

    // Vid 30,paso 32, pasando múltiples variables
    // http://localhost:8080/api/var/mix/funko/2
    @GetMapping("/mix/{product}/{id}")
    // usamos un map
    public Map<String, Object> mixPathVar(@PathVariable String product, @PathVariable Long id) {

        Map<String, Object> json = new HashMap<>();
        // Asignamos las variables
        json.put("product", product);
        json.put("id", id);

        return json;
    }

    // Vid 31 ,paso 33,creamos el post para postman
    // http://localhost:8080/api/var/values
    @PostMapping("/create")
    public User create(@RequestBody User user) {
        // hacer algo con el usuario save en la bbdd
        user.setName(user.getName().toUpperCase());
        return user;
    }

    // Vid 32,paso 35
    // http://localhost:8080/api/var/values
    @GetMapping("/values")
    // inyectamos @Value("${config.message}") String message)
    public Map<String, Object> values(@Value("${config.message}") String message) {
        // Vid 37,paso 45, otra forma de convertir el valor
        Long code2 = environment.getProperty("config.code", Long.class);

        Map<String, Object> json = new HashMap<>();
        // paso 36,devolvemos nuestro json como map
        json.put("username", username);
        json.put("code", code);
        json.put("message", message);
        // Vid 37,paso 44
        json.put("message2", environment.getProperty("config.message"));
        //
        json.put("code2", code2);
        json.put("listOfValues", listOfValues);
        json.put("valueString", valueString);
        // Vid 35
        json.put("valueList", valueList);
        // Vid 37
        json.put("valueMap", valuesMap);
        json.put("product", product);
        json.put("price", price);
        return json;
    }
}
