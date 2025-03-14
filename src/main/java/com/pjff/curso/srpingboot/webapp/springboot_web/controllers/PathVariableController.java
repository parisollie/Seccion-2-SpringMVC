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

//V-29,paso 2.12,para poder enviar parámetros a nuestra ruta.
@RestController
@RequestMapping("/api/var")
public class PathVariableController {

    /*
     * V-32, paso 2.17,ponemos nuestros atributos privados
     * Inyectamos configuraciones. con ("${config.username}") y el
     * nombre que pusimos en el archivo values.properties
     */
    @Value("${config.username}")
    private String username;

    @Value("${config.listOfValues}")
    // V-35,paso 2.24 ,pasamos una lista
    private List<String> listOfValues;

    @Value("${config.code}")
    private Integer code;

    /*
     * Paso 2.25, lenguaje de expresiones colocamos #{},split para poder convertir
     * en un arreglo, # es un lenguaje de expresion, con (,) lo va separando
     */
    @Value("#{'${config.listOfValues}'.toUpperCase().split(',')}")
    private List<String> valueList;

    @Value("#{'${config.listOfValues}'.toUpperCase()}")
    private String valueString;

    // V-36,paso 2.38
    @Value("#{${config.valuesMap}}")
    private Map<String, Object> valuesMap;

    // Paso 2.40
    @Value("#{${config.valuesMap}.product}")
    private String product;

    // Paso 2.41
    @Value("#{${config.valuesMap}.price}")
    private Long price;

    /*
     * V-37,paso 2.42, autocableado ,sistema de inyeccion , lo que hace buscar un
     * compoenente de spring en su contenedor
     */
    @Autowired
    private Environment environment;

    /*
     * V-29,paso 2.13
     * mando el mensaje hello( lo escribimos)
     * http://localhost:8080/api/var/baz/hello
     */
    @GetMapping("/baz/{message}")
    // para capturar el parámetro que varía ponemos @PathVariable String message
    public ParamDto baz(@PathVariable String message) {

        ParamDto param = new ParamDto();
        param.setMessage(message);
        return param;
    }

    /*
     * V-30,paso 2.14, pasando múltiples variables
     * http://localhost:8080/api/var/mix/funko/2
     */
    @GetMapping("/mix/{product}/{id}")
    // usamos un map
    public Map<String, Object> mixPathVar(@PathVariable String product, @PathVariable Long id) {

        Map<String, Object> json = new HashMap<>();
        // Asignamos las variables
        json.put("product", product);
        json.put("id", id);

        return json;
    }

    /*
     * V-31 ,paso 2.15,creamos el post para "Postman"
     * http://localhost:8080/api/var/values
     */
    @PostMapping("/create")
    public User create(@RequestBody User user) {
        // hacer algo con el usuario save en la bbdd
        user.setName(user.getName().toUpperCase());
        return user;
    }

    /*
     * V-32,paso 2.18
     * http://localhost:8080/api/var/values
     */
    @GetMapping("/values")
    // inyectamos @Value("${config.message}") String message)
    public Map<String, Object> values(@Value("${config.message}") String message) {
        // Paso 2.44, otra forma de convertir el valor
        Long code2 = environment.getProperty("config.code", Long.class);

        // Paso 2.19, creamos un mapa
        Map<String, Object> json = new HashMap<>();
        // Devolvemos nuestro json como map
        json.put("username", username);
        json.put("code", code);
        json.put("message", message);
        json.put("listOfValues", listOfValues);

        // paso 2.26
        json.put("valueList", valueList);
        json.put("valueString", valueString);

        // V-36,paso 2.39
        json.put("valueMap", valuesMap);
        json.put("product", product);
        json.put("price", price);

        // V-37,paso 2.43
        json.put("message2", environment.getProperty("config.message"));
        json.put("code2", code2);

        return json;

    }
}
