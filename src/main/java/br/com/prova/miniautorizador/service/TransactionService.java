package br.com.prova.miniautorizador.service;


import br.com.prova.miniautorizador.entity.Cartao;
import br.com.prova.miniautorizador.entity.form.TransactionForm;
import br.com.prova.miniautorizador.repository.CartaoRepository;
import br.com.prova.miniautorizador.resources.exceptions.CardNumberExceptionNotFound;
import br.com.prova.miniautorizador.resources.exceptions.GenericException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final CartaoRepository cartaoRepository;

    private final CartaoService cartaoService;

    public Cartao debito(TransactionForm form) {
        Cartao cartao = cartaoRepository.findCartaoByNumeroCartao(form.getNumeroCartao()).orElseThrow(() -> new CardNumberExceptionNotFound(form.getNumeroCartao().toString(), "cartao"));
        //Cartao cartao = cartaoService.findById(7L);
        if (form.getConfirmPassword().equals(cartao.getPassword())) {
            if (form.getValor() <= cartao.getSaldo()) {
                double novoSaldo = cartao.getSaldo() - form.getValor();
                cartao.setSaldo(novoSaldo);
                return cartaoRepository.save(cartao);
            } else {
                throw new GenericException("Saldo Insuficiente!");
            }
        } else throw new GenericException("Senha incorreta!");
    }

}
