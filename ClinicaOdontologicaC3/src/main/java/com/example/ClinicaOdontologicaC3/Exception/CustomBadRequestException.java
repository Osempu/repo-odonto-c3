package com.example.ClinicaOdontologicaC3.Exception;

import org.apache.coyote.BadRequestException;

public class CustomBadRequestException extends BadRequestException {

    // Llama a la implementacion de la clase padre pasando el mensaje de error.
    public CustomBadRequestException(String message) {
        super(message);
    }
}
