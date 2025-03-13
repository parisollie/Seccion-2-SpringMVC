package com.pjff.curso.srpingboot.webapp.springboot_web.models;

//V-16,paso 1.11, creamos el User 
public class User {
    // Creamos los atributos de nuestra persona.
    private String name;
    private String lastname;

    // V-22,paso 1.24,ponemos un atributo y le ponemos sus settes and getters
    private String email;

    // ----------------------------CONSTRUCTOR --------------------

    // Paso 1.14 , creamos un constructor vacío
    public User() {
    }

    // V-24 Paso 1.13, creamos un constructor, hay repetidos.
    public User(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }

    // Paso 1.33, creamos un constructor con los 3 campos
    public User(String name, String lastname, String email) {
        // reutilizamos el constructor del paso 8 ,porque ta tenemos esos campos
        this(name, lastname);
        this.email = email;
    }

    // ----------------------------SETTERS AND GETTERS --------------

    // Paso 1.12
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
