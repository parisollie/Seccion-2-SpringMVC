package com.pjff.curso.srpingboot.webapp.springboot_web;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

//Vid 33,paso 38
@Configuration
// le ponemos el properties que creamos
@PropertySources({
        // Vid 34,paso 39, para los acentos y ñ , le ponemos el utf8
        @PropertySource(value = "classpath:values.properties", encoding = "UTF-8"),
})
public class ValuesConfig {

}
