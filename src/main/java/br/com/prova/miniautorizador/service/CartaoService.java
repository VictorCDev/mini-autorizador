package br.com.prova.miniautorizador.service;

import br.com.prova.miniautorizador.entity.Cartao;
import br.com.prova.miniautorizador.entity.form.CartaoForm;
import br.com.prova.miniautorizador.repository.CartaoRepository;
import br.com.prova.miniautorizador.service.exceptions.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartaoService {

    private final CartaoRepository cartaoRepository;

    public List<Cartao> getAll() {
        return cartaoRepository.findAll();
    }

    public Cartao findById(Long id) {
        Optional<Cartao> obj = cartaoRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Cartao.class.getName()));
    }

    public Cartao create(CartaoForm form) {
        Cartao cartao = new Cartao();
        cartao.setNumeroCartao(form.getNumeroCartao());
        cartao.setPassword(form.getPassword());
        cartao.setSaldo(500.0);

        return cartaoRepository.save(cartao);
    }

    /* public Cartao update(Long id, CartaoForm obj) {
        Cartao newObj = findById(id);
        newObj.setSaldo(obj.getSaldo());
        return cartaoRepository.save(newObj);
    } */

    public void delete(Long id){
        findById(id);
        cartaoRepository.deleteById(id);
    }
}
