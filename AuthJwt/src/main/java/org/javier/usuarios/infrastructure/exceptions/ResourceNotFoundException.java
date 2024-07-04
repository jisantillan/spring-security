package org.javier.usuarios.infrastructure.exceptions;

public class ResourceNotFoundException extends Exception {
    public ResourceNotFoundException() {
        super();
    }
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
