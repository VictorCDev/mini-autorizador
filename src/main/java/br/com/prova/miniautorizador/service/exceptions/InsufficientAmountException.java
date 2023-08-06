package br.com.prova.miniautorizador.service.exceptions;

public class InsufficientAmountException extends RuntimeException{

    public InsufficientAmountException(String msg){
        super(msg);
    }
}
