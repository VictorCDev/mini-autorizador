package br.com.prova.miniautorizador.controller;

import br.com.prova.miniautorizador.entity.Cartao;
import br.com.prova.miniautorizador.entity.form.CartaoForm;
import br.com.prova.miniautorizador.service.CartaoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cartao")
@Slf4j
@RequiredArgsConstructor
public class CartaoController {

    private final CartaoService service;

    @GetMapping
    public List<Cartao> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Cartao findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping("/create")
    public Cartao create(@RequestBody CartaoForm form) {
        return service.create(form);
    }

    /* @PutMapping("/{id}")
    public ResponseEntity<Cartao> update(@PathVariable Long id, @RequestBody CartaoForm obj) {
        Cartao newObj = service.update(id, obj);
        return ResponseEntity.ok().body(newObj);
    } */

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
