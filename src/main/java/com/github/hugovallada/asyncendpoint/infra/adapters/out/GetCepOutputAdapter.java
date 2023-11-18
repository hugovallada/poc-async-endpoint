package com.github.hugovallada.asyncendpoint.infra.adapters.out;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.hugovallada.asyncendpoint.application.dto.AddressDTO;
import com.github.hugovallada.asyncendpoint.application.port.out.GetCepOutputPort;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GetCepOutputAdapter implements GetCepOutputPort {

    @Override
    public AddressDTO execute(String cep) {
        try {
            Thread.sleep(5000);
            final var client = HttpClient.newHttpClient();
            final var uri = new URI(String.format("https://viacep.com.br/ws/%s/json/", cep));
            final var request = HttpRequest.newBuilder(uri).GET().build();
            final var response = HttpResponse.BodyHandlers.ofString();
            var stringResponse = client.send(request, response);
            return new ObjectMapper().readValue(stringResponse.body(), AddressDTO.class);
        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
