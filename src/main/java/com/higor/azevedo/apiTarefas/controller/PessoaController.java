package com.higor.azevedo.apiTarefas.controller;

import com.higor.azevedo.apiTarefas.dto.PessoaDTO;
import com.higor.azevedo.apiTarefas.dto.PessoaHorasGastasDTO;
import com.higor.azevedo.apiTarefas.service.pessoa.PessoaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    private final PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @PostMapping
    public ResponseEntity<PessoaDTO> salvar(@RequestBody PessoaDTO pessoaDTO) throws Exception {
        PessoaDTO pessoa = pessoaService.salvar(pessoaDTO);
        return ResponseEntity.status(HttpStatus.OK).body(pessoa);
    }

    @PutMapping("{id}")
    public ResponseEntity<PessoaDTO> atualizar(@PathVariable("id") Long id, @RequestBody PessoaDTO pessoaDTO) throws Exception {
        PessoaDTO pessoa = pessoaService.atualizar(id, pessoaDTO);
        return ResponseEntity.status(HttpStatus.OK).body(pessoa);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deletar(@PathVariable("id") Long id) throws Exception {
        pessoaService.deletar(id);
        return ResponseEntity.status(HttpStatus.OK).body("Dados da pessoa deletados");
    }

    @GetMapping
    public ResponseEntity<List<PessoaHorasGastasDTO>> listar() {
        List<PessoaHorasGastasDTO> pessoas = pessoaService.listarPessoas();
        return ResponseEntity.status(HttpStatus.OK).body(pessoas);
    }
}
