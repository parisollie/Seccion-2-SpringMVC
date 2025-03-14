package com.pjff.curso.srpingboot.webapp.springboot_web.models.dto;

//V-27 ,Paso 2.9 creamos la clase
public class ParamMixDto {
    // Ponemos sus atributos
    private String message;

    private Integer code;

    // ----------------------------SETTERS AND GETTERS --------------

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

}
