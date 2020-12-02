package com.poc.circuitbreaker.client.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ErrorResponse {

    private String erro;
}
