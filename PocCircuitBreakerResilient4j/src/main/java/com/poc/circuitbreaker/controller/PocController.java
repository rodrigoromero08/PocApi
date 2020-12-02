package com.poc.circuitbreaker.controller;

import com.poc.circuitbreaker.client.response.ErrorResponse;
import com.poc.circuitbreaker.client.response.UsuarioResponse;
import com.poc.circuitbreaker.services.UsuarioService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RequestMapping("/api/poc")
@RestController
public class PocController {

    private UsuarioService usuarioService;

    @GetMapping("/testar")
    @CircuitBreaker(name = "buscar", fallbackMethod = "remoteCallFail")
    public ResponseEntity testar(@RequestParam String idUsuario){

        UsuarioResponse usuarioResponse = usuarioService.buscar(idUsuario);

        return ResponseEntity.ok(usuarioResponse);

    }

    public ResponseEntity remoteCallFail(String msg, Exception e){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ErrorResponse.builder().erro(msg).build());
    }
}
