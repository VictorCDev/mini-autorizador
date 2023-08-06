package br.com.prova.miniautorizador.controller;

import br.com.prova.miniautorizador.entity.Cartao;
import br.com.prova.miniautorizador.entity.form.TransactionForm;
import br.com.prova.miniautorizador.service.TransactionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaction")
@Slf4j
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService service;

    @PutMapping("/debito")
    public ResponseEntity<Cartao> debito(@RequestBody TransactionForm form) {
        Cartao cartao = service.debito(form);
        return ResponseEntity.ok().body(cartao);
    }
}
