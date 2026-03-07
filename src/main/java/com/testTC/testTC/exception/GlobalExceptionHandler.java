package com.testTC.testTC.exception;


import com.testTC.testTC.payload.ApiResponse;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler  {
    //----------------------------------------------------
    //EXCEPTIONS PERSONALIZADAS POR EL PROGRAMADOR
    //----------------------------------------------------
    //Controla errores not found 404
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handleResourceNotFoundException(ResourceNotFoundException exception, WebRequest webRequest){
        ApiResponse apiResponse = new ApiResponse(exception.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
    }
    //apiResponse es el objeto que va a serializar como json en el cuerpo de la response, HTTPStatus el estado
    //Controla errores de logica de negocio, en general 400
    @ExceptionHandler(BussinesException.class)
    public ResponseEntity<ApiResponse> handleBussinesException(BussinesException exception, WebRequest webRequest){
        ApiResponse apiResponse = new ApiResponse(exception.getMessage(), webRequest.getDescription(false));
        return  new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
    }
    //----------------------------------------------------
    //----------------------------------------------------
    //EXCEPTIONS QUE LANZA SPRING
    //----------------------------------------------------

    //Evita duplicados en campos claves
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ApiResponse> handleDataIntegrityViolationException (DataIntegrityViolationException exception, WebRequest webRequest){
        String mensaje = "Dato duplicado o violacion de restriccion en base de datos.";
        ApiResponse apiResponse = new ApiResponse(mensaje, webRequest.getDescription(false));
        return new ResponseEntity<>(apiResponse, HttpStatus.CONFLICT);
    }
    //Controla errores globales de los path
    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<ApiResponse> handleNoHandlerFoundException(NoHandlerFoundException exception, WebRequest webRequest){
        ApiResponse apiResponse = new ApiResponse("El endpoint al que intentas acceder no existe.", webRequest.getDescription(false));
        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
    }

    //Controla errores de campos incompletos en el envio de entidades
    //error es de tipo ObjectError, que es la clase base que usa Spring para representar cualquier error de validación
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleMethodArgumentNotValidException (MethodArgumentNotValidException exception, WebRequest webRequest){
        Map<String, String> mapErrores = new HashMap<>();
        exception.getBindingResult().getAllErrors().forEach((error)-> {
            String clave = ((FieldError) error).getField();
            String valor = error.getDefaultMessage();
            mapErrores.put(clave, valor);
        }) ;
        ApiResponse apiResponse = new ApiResponse(mapErrores.toString(), webRequest.getDescription(false));
        return  new ResponseEntity<>(apiResponse,HttpStatus.BAD_REQUEST);
    }

    //Controla errores cuando el json del body contiene errores
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ApiResponse> handleHttpMessageNotReadableException(HttpMessageNotReadableException exception, WebRequest webRequest){
        ApiResponse apiResponse = new ApiResponse("El body del request tiene errores de sintaxis o esta mal formado.", webRequest.getDescription(false));
        return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
    }

    //Controla los errores no especificados en otras exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse> handleException (Exception exception, WebRequest webRequest){
        ApiResponse apiResponse = new ApiResponse(exception.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}

//Excepciones controladas en la API
//1-Propias — recurso no encontrado en la DB (ResourceNotFoundException) y violación de regla de negocio (BusinessException).
//2-Base de datos — dato duplicado o violación de restricción de integridad (DataIntegrityViolationException).
//3-Validación de campos — campos vacíos o inválidos en el request según @Valid (MethodArgumentNotValidException).
//4-Ruta inexistente — endpoint que no existe en la aplicación (NoHandlerFoundException).
//5-Body mal redactado - detecta errores al enviar el json en el body (HttpMessageNotReadableException)
//6-Red de seguridad — cualquier error no contemplado en los handlers anteriores (Exception).

//HttpMessageNotReadableException — el JSON llega pero está mal escrito, Jackson no lo puede leer.
//MethodArgumentNotValidException — el JSON llega bien formado, Jackson lo lee sin problema, pero los valores no pasan las validaciones de @Valid como @NotBlank o @NotNull.
//uno es error de sintaxis, el otro es error de contenido.
