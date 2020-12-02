package com.poc.circuitbreaker.client.response;

import lombok.Data;

@Data
public class UsuarioResponse {

    private String id;
    private String nome;
    private String cpf;
}
