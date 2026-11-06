package com.example.aulas.aula3.controller;

import org.springframework.web.bind.annotation.*;

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

    //curl -X POST http://localhost:8080/ola-mundo
    @PostMapping("/{id}") //Chama esse metodo quando o verbo é POST
    public String criar(@PathVariable Long id){
        return "Criado " + id;
    }

    //curl -X PUT http://localhost:8080/ola-mundo/SEU-ID
    @PutMapping("/{id}")
    public String atualizar(@PathVariable Long id){
        return "Atualizado " + id;
    }
    //curl -X PUT http://localhost:8080/ola-mundo/
    @PutMapping
    public String atualizar() {
        return "Atualizado";
    }
    //curl -X DELETE http://localhost:8080/ola-mundo/SEU-ID
    @DeleteMapping("/{id}")
    public String deletar(@PathVariable Long id){
        return "Deletado " + id;
    }
    //curl -X DELETE http://localhost:8080/ola-mundo
    @DeleteMapping
    public String deletar(){
        return "Deletado ";
    }

    //curl -X GET "http://localhost:8080/ola-mundo/busca?nome=Flora"
    @GetMapping("/busca")
    public String buscar(@RequestParam String nome){
        return "Buscando por: " + nome;
    }

  /* @GetMapping("/tarefa")
    public Tarefa umaTarefa(){
        return new Tarefa(1L, "Estudar Spring", false);
    }
    */
}
