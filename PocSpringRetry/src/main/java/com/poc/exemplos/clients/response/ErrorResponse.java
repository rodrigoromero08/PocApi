package com.poc.exemplos.clients.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ErrorResponse {

    private String erro;
}
