package br.com.leticiaisrael.apilet.services.exceptions;

public class DataIntegratyViolationException extends RuntimeException{
    public DataIntegratyViolationException(String message) {

        super(message);
    }
}
