package com.poc.circuitbreaker.services;

import com.poc.circuitbreaker.client.UsuarioClient;
import com.poc.circuitbreaker.client.response.UsuarioResponse;
import com.poc.circuitbreaker.services.exceptions.ApiUsuarioException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@AllArgsConstructor
@Service
public class UsuarioService {

    private UsuarioClient usuarioClient;


    public UsuarioResponse buscar(String idUsuario) {
        try {
            log.info("chamando API usuarios");
            return usuarioClient.buscarUsuario(idUsuario);
        }catch(Exception e){
            log.error(e.getMessage(), e);
            throw new ApiUsuarioException(e.getMessage(), e);
        }
    }


}
