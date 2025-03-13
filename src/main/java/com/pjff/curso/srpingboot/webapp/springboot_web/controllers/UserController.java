package com.pjff.curso.srpingboot.webapp.springboot_web.controllers;

import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.pjff.curso.srpingboot.webapp.springboot_web.models.User;

@Controller
// V-12,Paso 1.0 - creamos el user controller
public class UserController {
    // GetMapping petición de una ruta y empieza con (/)
    @GetMapping("/details")
    /*
     * V-13,Paso 1.1, inyectamos dependencias y le ponemos "model"
     * devuelve un string su nombre es details y es un método
     */
    public String details(Model model) {

        // V-16 Paso 1.16,ponemos nuestro objeto.
        User user = new User("Joaquin", "Sandoval");
        /*
         * V-22,Paso 1.26 le ponemos su correo y si lo comentamos aparece que no
         * user.setEmail("joaquin@correo.com");
         * 
         * Paso 1.3, inyectamos el "tittle" es lo que le pasaremos a la vista HTML,
         * que se llama details que se encuentra en la carpeta templates.
         */
        model.addAttribute("title", "Hola Mundo Spring Boot");
        model.addAttribute("user", user);

        // Regresa el mismo nombre de la plantilla
        return "details";
    }

    /*
     * V-23,Paso 1.27, creamos metodo del tipo list,una lista tn thymeleaf
     * http://localhost:8080/list
     */
    @GetMapping("/list")
    // devuelve el nombre que es list
    public String list(ModelMap model) {
        model.addAttribute("title", "Listado de usuarios!");
        return "list";
    }

    /*
     * V-25,Paso 2.2 le damos un nombre de atributo a la vista,pasar datos a la
     * vista, es global al controlador
     */
    @ModelAttribute("users")

    // V-25,Paso 2.1
    public List<User> usersModel() {
        // V-24,Paso 1.30, agregamos usuarios a la lista.
        return Arrays.asList(
                new User("Juan", "Gonzalez"),
                new User("Rafel", "Ramo", "ramo@correo.com"),
                new User("Miles", "Roe", "juana@correo.com"),
                new User("Andrew", "Riordan"));
    }

}
