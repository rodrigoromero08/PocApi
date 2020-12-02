package com.poc.circuitbreaker.controllers;

import com.poc.circuitbreaker.response.UsuarioResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private static HashMap<String, UsuarioResponse> mapa = getMapa();


    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponse> buscarUsuario(@PathVariable String id){
        Optional<UsuarioResponse> optional = getUsuario(id);
        return optional.isPresent() ? ResponseEntity.ok(optional.get()) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();

    }

    private Optional<UsuarioResponse> getUsuario(String id) {
        return mapa.containsKey(id)? Optional.of(mapa.get(id)):Optional.empty();
    }

    private static HashMap<String, UsuarioResponse> getMapa() {

        HashMap<String, UsuarioResponse> mapa = new HashMap<>();

        mapa.put("1", UsuarioResponse.builder().id("1").cpf("22200089813").nome("Fernanda Silva").build());
        mapa.put("2", UsuarioResponse.builder().id("2").cpf("22200089213").nome("Fernando Silva").build());
        mapa.put("3", UsuarioResponse.builder().id("3").cpf("22200089413").nome("Gustavo Silva").build());

        return mapa;
    }

}
