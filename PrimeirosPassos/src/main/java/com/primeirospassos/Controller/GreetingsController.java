package com.primeirospassos.Controller;


import com.primeirospassos.Model.Greetings;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

@RestController()
@RequestMapping("/cleiton")
public class GreetingsController {

    private String greeting;
    private AtomicInteger counter = new AtomicInteger(); //Faz o incremento do ID com uma sequência a cada nova requisição.


    @RequestMapping("/new")
    public Greetings gerarGreetings(@RequestParam(name = "msg",defaultValue = "World", required=false) String msg, @RequestParam(name = "idade", required = false, defaultValue = "") String idade) {
        //URL EXEMPLO = http://localhost:8080/cleiton/new?msg=Wellinton&idade=20
        counter.incrementAndGet(); //Metodo do AtomicInteger para incrementar.
        if (Objects.equals(idade, "")) {
            msg = "Hello " + msg + "!";
        } else {
            msg = "Hello " + msg + "!" + "\n" + "Idade: " + idade;
        }

        return new Greetings(Long.parseLong(String.valueOf(counter)), msg); //Estou convertendo o AtomicInteger(counter) para String e depois para Long.
    }
}
