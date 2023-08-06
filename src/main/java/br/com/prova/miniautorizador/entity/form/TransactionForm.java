package br.com.prova.miniautorizador.entity.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionForm {

    private Double valor;

    private String confirmPassword;

    private Long numeroCartao;
}
