package com.example.ClinicaOdontologicaC3.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {
    /**
     * Manejo global de excepcion cuando un recurso no es encontrado
     * @param rnfe Resource Not Found Exception
     * @return returna el codigo de error junto con un mensaje
     */
    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<String> tratamientoResourceNotFoundException(ResourceNotFoundException rnfe){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("mensaje: "+rnfe.getMessage());
    }

    /**
     * Manejo global de excepcion cuando se crea un request erroneo
     * @param rnfe Custom Bad Request Exception
     * @return returna el codigo de error junto con un mensaje
     */
    @ExceptionHandler({CustomBadRequestException.class})
    public ResponseEntity<String> tratamientoCustomBadRequestException(CustomBadRequestException cbre){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("mensaje: "+cbre.getMessage());
    }

}
