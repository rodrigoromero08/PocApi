package com.poc.exemplos.services;

import com.poc.exemplos.clients.UsuarioClient;
import com.poc.exemplos.clients.response.UsuarioResponse;
import com.poc.exemplos.exceptions.ApiUsuarioException;
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