package com.testTC.testTC.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    private String nombreEntidad;
    private String nombreCampoEntidad;
    private Object valorAtributo;


    public ResourceNotFoundException(String nombreEntidad, String nombreCampoEntidad, Object valorAtributo) {
        super(String.format("El campo %s no posee un %s con valor = '%s' ", nombreEntidad, nombreCampoEntidad,valorAtributo));
        this.nombreEntidad = nombreEntidad;
        this.nombreCampoEntidad = nombreCampoEntidad;
        this.valorAtributo = valorAtributo;

    }
    public ResourceNotFoundException (String nombreEntidad){
        super(String.format("El sistema no posee registros para %s", nombreEntidad));
        this.nombreEntidad = nombreEntidad;
    }
}
