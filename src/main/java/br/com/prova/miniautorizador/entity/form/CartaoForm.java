package br.com.prova.miniautorizador.entity.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartaoForm {


    @Size(min=6, max=10, message = "'${validValue}' precisa estar entre {min} e {max} caracteres.")
    private String password;

    private Long numeroCartao;

    private Long saldo;
}
