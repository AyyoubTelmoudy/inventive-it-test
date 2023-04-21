package com.inventiveit.exception;

import com.inventiveit.constant.ErrorMessage;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

/*
  This class contains the methods that handle exceptions triggered in applications and replay with a customized response
*/

@ControllerAdvice
public class AppExceptionHandler {

    /*
     This method gets executed when rule of a field in requested body is violated
    */
    @ExceptionHandler(value= MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex,WebRequest request){
        Map<String,String> errors=new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error->errors.put(error.getField(),error.getDefaultMessage()));
        return new ResponseEntity<>(errors,new HttpHeaders(),HttpStatus.BAD_REQUEST);
    }

    /*
     This method gets executed when the json object or the massage sent to the endpoints is not readable or malformed
    */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Object> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
        Map<String,String> errors=new HashMap<>();
        errors.put(ErrorMessage.ERROR,ErrorMessage.MALFORMED_JSON_REQUEST_BODY);
        return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
    }

    /*
      This method gets executed when a client tries to get a DreamCase that does not exist
    */

    @ExceptionHandler(value=DreamCaseNotFoundException.class)
    public ResponseEntity<Object> handleDreamCaseNotFoundException(DreamCaseNotFoundException ex, WebRequest request){
        Map<String,String> errors=new HashMap<>();
        errors.put(ErrorMessage.ERROR,ErrorMessage.DREAM_CASE_NOT_FOUND);
        return new ResponseEntity<>(errors,new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

}
