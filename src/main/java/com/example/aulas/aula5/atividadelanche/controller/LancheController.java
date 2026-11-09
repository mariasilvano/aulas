package com.example.aulas.aula5.atividadelanche.controller;

import com.example.aulas.aula5.atividadelanche.model.Lanche;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/lanches")
public class LancheController {
    private List<Lanche> lanches = new ArrayList<>();
    private int proximoId = 1;

    @GetMapping
    public List<Lanche> listar(){
        return lanches;
    }

    @GetMapping("/{id}")
    public Lanche buscar(@PathVariable int id){
        for(Lanche lanche : lanches){
            if (lanche.getId() == id){
                return lanche;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Lanche não encontrado");
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Lanche cadastrar(@RequestBody Lanche lanche){
        if(lanche.getPreco() <= 0){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O preço do lanche deve ser maior que zero!");
        }
        lanche.setId(proximoId);
        lanches.add(lanche);
        proximoId++;
        return lanche;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable int id){
        Lanche existente = buscar(id);
        lanches.remove(existente);
    }
}
