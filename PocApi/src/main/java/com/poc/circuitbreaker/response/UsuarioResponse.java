package com.poc.circuitbreaker.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UsuarioResponse {

    private String id;
    private String nome;
    private String cpf;
}
