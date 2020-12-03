package com.poc.exemplos.clients;

import com.poc.exemplos.clients.response.UsuarioResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "client", url = "${api.usuario.url}")
public interface UsuarioClient {

    @GetMapping("/{id}")
    UsuarioResponse buscarUsuario(@PathVariable String id);
}
