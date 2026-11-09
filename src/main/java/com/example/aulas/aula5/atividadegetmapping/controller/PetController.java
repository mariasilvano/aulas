package com.example.aulas.aula5.atividadegetmapping.controller;

import com.example.aulas.aula5.atividadegetmapping.model.Pet;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pets")
public class PetController {
    @GetMapping("")
    public String ola(){
        return "Bem-vinda ao Pet Shop Elas Tech!";
    }
    @GetMapping("/horario")
    public String horario(){
        return "Abrimos de segunda a sábado, das 8h às 18h.";
    }
    @GetMapping("/destaque")
    public Pet destaque(){
        return new Pet("Thor", "Cachorro", 3);
    }

    @GetMapping("/adotar/{nome}")
    public String destaque(@PathVariable String nome){
        return "Parabéns! Você adotou " + nome + "!";
    }

    @GetMapping("/banho")
    public String banho(@RequestParam(defaultValue = "Seu pet") String nome){
        return nome + " está tomando banho!";
    }

    @GetMapping("/novo/{nome}")
    public Pet cadastrar(@PathVariable String nome){
        return new Pet(nome, "Gato", 1);
    }

    @GetMapping("/idade-humana")
    public String calcularIdadeHumana(@RequestParam (defaultValue = "0") int idade){
        return idade + " anos de pet equivalem a "+(idade *7)+ " anos humanos!";
    }

    @GetMapping("/consulta")
    public String consultar(@RequestParam(defaultValue = "Pet não informado") String pet,
    @RequestParam(defaultValue = "Veterinário(a) não informado") String vet){
        return pet + " tem consulta com a Dr(a) " + vet +"!";
    }

}
