package com.poc.exemplos.controllers;

import com.poc.exemplos.clients.response.ErrorResponse;
import com.poc.exemplos.clients.response.UsuarioResponse;
import com.poc.exemplos.exceptions.ApiUsuarioException;
import com.poc.exemplos.services.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RequestMapping("/api/poc")
@RestController
public class PocController {

    private UsuarioService usuarioService;

    @Retryable(value = {ApiUsuarioException.class}, maxAttempts = 4, backoff = @Backoff(2000))
    @GetMapping("/testar")
    public ResponseEntity testar(@RequestParam String idUsuario){

        UsuarioResponse usuarioResponse = usuarioService.buscar(idUsuario);

        return ResponseEntity.ok(usuarioResponse);

    }

    @Recover
    public ResponseEntity remoteCallFail(String msg, Exception e){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ErrorResponse.builder().erro(msg).build());
    }
}
