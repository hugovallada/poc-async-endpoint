package com.github.hugovallada.asyncendpoint.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record AddressDTO(String cep, @JsonProperty("logradouro") String rua, String complemento, String bairro,
                         @JsonProperty("localidade") String cidade, @JsonProperty("uf") String estado, String ibge,
                         String gia, String ddd, String siafi) {
}
