package com.pjff.curso.srpingboot.webapp.springboot_web;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

//V-33,paso 2.22 creamos nuestro archivo de configuraci
@Configuration
// le ponemos el properties que creamos
@PropertySources({
        // V-34,paso 2.23, para los acentos y ñ , le ponemos el utf8
        @PropertySource(value = "classpath:values.properties", encoding = "UTF-8"),
})

public class ValuesConfig {

}
