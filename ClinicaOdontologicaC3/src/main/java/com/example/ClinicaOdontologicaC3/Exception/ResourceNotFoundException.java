package com.example.ClinicaOdontologicaC3.Exception;

public class ResourceNotFoundException extends Exception {

    // Llama a la implementacion de la clase padre pasando el mensaje de error
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
