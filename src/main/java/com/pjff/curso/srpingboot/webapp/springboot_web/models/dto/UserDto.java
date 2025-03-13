package com.pjff.curso.srpingboot.webapp.springboot_web.models.dto;

import com.pjff.curso.srpingboot.webapp.springboot_web.models.User;

//Vid 19 ,paso 10, creamos el DTO , tambien es un POJO 
public class UserDto {

    private String title;
    private User user;

    // paso 11 ,ponemos sus getter and setters
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
