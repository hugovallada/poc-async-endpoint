package com.github.hugovallada.asyncendpoint.infra.adapters.out;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.hugovallada.asyncendpoint.application.dto.AddressDTO;
import com.github.hugovallada.asyncendpoint.application.dto.Result;
import com.github.hugovallada.asyncendpoint.application.port.out.GetCepOutputPort;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GetCepOutputAdapter implements GetCepOutputPort {

    private final ObjectMapper objectMapper;

    public GetCepOutputAdapter(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public Result<AddressDTO, IllegalStateException> execute(String cep) {
        try {
            Thread.sleep(5000);
            final var client = HttpClient.newHttpClient();
            final var uri = new URI(String.format("https://viacep.com.br/ws/%s/json/", cep));
            final var request = HttpRequest.newBuilder(uri).GET().build();
            final var response = HttpResponse.BodyHandlers.ofString();
            var httpResponse = client.send(request, response);
            if (httpResponse.statusCode() != 200) {
                return Result.<AddressDTO, IllegalStateException>builder()
                        .error(new IllegalStateException("status inválido"))
                        .build();
            }
            return Result.<AddressDTO, IllegalStateException>builder()
                    .sucesso(objectMapper.readValue(httpResponse.body(), AddressDTO.class))
                    .build();
        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
