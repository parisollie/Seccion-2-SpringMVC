package com.pjff.curso.srpingboot.webapp.springboot_web.models.dto;

import com.pjff.curso.srpingboot.webapp.springboot_web.models.User;

/*
   V-19 ,paso 1.18, creamos el DTO , tambien es un POJO 
   DTO, objeto de transferencia de datos  es un objeto que 
   transporta datos entre procesos.
*/

public class UserDto {

    private String title;
    private User user;

    // ----------------------------SETTERS AND GETTERS --------------

    // Paso 1.19
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
