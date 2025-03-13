package com.pjff.curso.srpingboot.webapp.springboot_web.controllers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pjff.curso.srpingboot.webapp.springboot_web.models.User;
import com.pjff.curso.srpingboot.webapp.springboot_web.models.dto.UserDto;

//V-14,Paso 1.7 ,creamos un  RestController para poder crear un APIREST
@RestController
// V-15,paso 1.9 le ponemos la ruta "api"
@RequestMapping("/api")
public class UserRestController {
    /*
     * Paso 1.10 ,GetMapping es un alias es un atajo mas simple,request mapping
     * es del tipo get: http://localhost:8080/api/details
     */
    @GetMapping(path = "/details")
    /*
     * V-19,Paso 1.20 ,aplicamos el DTO(data transfer object)
     * en vez del map que aplicamos anteriormente.
     */
    public UserDto details() {

        // Paso 9,creamos nuestro objeto y nuestra instancia.
        User user = new User("Andrew", "Riordan");

        // Paso 1.21 ,aplicamos el DTO
        UserDto userDto = new UserDto();
        userDto.setUser(user);
        userDto.setTitle("Hola Mundo Spring Boot");

        // Devolvemos el userDto
        return userDto;
    }

    // http://localhost:8080/api/list
    @GetMapping("/list")
    // V-21,paso 1.22 ,creamos una arrreglo que nos devolverá una lista.
    public List<User> list() {
        // Creammos nuestros objetos
        User user = new User("Rafael", "Ramos");
        User user2 = new User("Ivan", "Doe");
        User user3 = new User("Jhon", "Doe");

        // Paso 1.23,usamos un helper,Arrays que es lo mismo que se hizo abajo.
        List<User> users = Arrays.asList(user, user2, user3);

        /*
         * Creamos un arrayList
         * List<User> users = new ArrayList<>();
         * users.add(user);
         * users.add(user2);
         * users.add(user3);
         */

        return users;
    }

    /*
     * Paso 1.8 con esta ruta lo vemos, usamos MAP
     * http://localhost:8080/api/details-map
     */
    @GetMapping(path = "/details-map")
    public Map<String, Object> detailsMap() {

        // V-16,Paso 1.15, creamos nuestro objeto
        User user = new User("Andrew", "Riordan");

        // Paso 1.8.1
        Map<String, Object> body = new HashMap<>();

        // Creamo un JSON , llave-valor
        body.put("title", "Hola Mundo Spring Boot");
        body.put("user", user);
        // Regresamos el body
        return body;
    }

}
