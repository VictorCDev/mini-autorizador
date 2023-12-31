package br.com.prova.miniautorizador.resources.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.text.MessageFormat;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CardNumberExceptionNotFound extends BusinessException {

    private static final long serialVersionUID = 1918184724741319997L;

    public static final String NOT_FOUND = "{1} {0} não encontrado";

    public CardNumberExceptionNotFound(String object, String objectDescription) {

        String description = MessageFormat.format(NOT_FOUND, object, objectDescription);

        super.setMessage(description);
        super.setDescription(description);
        super.setHttpStatusCode(HttpStatus.NOT_FOUND);
        super.setCode(String.valueOf(HttpStatus.NOT_FOUND.value()));
    }
}