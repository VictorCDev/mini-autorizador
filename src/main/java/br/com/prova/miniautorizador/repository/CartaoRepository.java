package br.com.prova.miniautorizador.repository;

import br.com.prova.miniautorizador.entity.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartaoRepository extends JpaRepository<Cartao, Long> {

    Optional<Cartao> findCartaoByNumeroCartao(Long numeroCartao);

    Optional<Cartao> findByNumeroCartao(Long numeroCartao);

}
