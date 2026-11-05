package com.example.aulas.aula3.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//diz que essa classe responde a http e faz json, não uma página da web
@RequestMapping("/ola-mundo")// determino o prefixo pra acessar todas as rotas dessa classe
public class OlaMundoController {

    @GetMapping
    public String olaMundo(){
        return "Olá Mundo!";
    }

    @GetMapping("/boas-vindas")
    public String bemVindo(){
        return "Seja bem vindo(a) a primeira página com Spring!";
    }
}
