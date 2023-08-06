package br.com.prova.miniautorizador.resources.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.text.MessageFormat;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class GenericException extends BusinessException {

    private static final long serialVersionUID = 1918184724741319997L;

    public static final String MESSAGE = "{0}";

    public GenericException(String object) {

        String description = MessageFormat.format(MESSAGE, object);

        super.setMessage(description);
        super.setDescription(description);
        super.setHttpStatusCode(HttpStatus.BAD_REQUEST);
        super.setCode(String.valueOf(HttpStatus.BAD_REQUEST.value()));
    }
}