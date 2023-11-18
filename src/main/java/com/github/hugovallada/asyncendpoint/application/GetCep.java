package com.github.hugovallada.asyncendpoint.application;

import com.github.hugovallada.asyncendpoint.application.entity.Address;
import com.github.hugovallada.asyncendpoint.application.port.in.GetCepUseCase;
import com.github.hugovallada.asyncendpoint.application.port.out.ErrorEventPublisherOutputPort;
import com.github.hugovallada.asyncendpoint.application.port.out.GetCepOutputPort;

import static java.lang.System.out;

public class GetCep implements GetCepUseCase {
    private final GetCepOutputPort getCep;
    private final ErrorEventPublisherOutputPort errorEventPublisher;

    public GetCep(GetCepOutputPort getCep, ErrorEventPublisherOutputPort errorEventPublisher) {
        this.getCep = getCep;
        this.errorEventPublisher = errorEventPublisher;
    }

    @Override
    public void execute(String cep) {
        final var resultAddressDTO = getCep.execute(cep);
        if (resultAddressDTO.isError()) {
            errorEventPublisher.execute(resultAddressDTO.error().getMessage());
            return;
        }
        final var addressDTO = resultAddressDTO.getOrThrow();
        final var address = Address.builder()
                .cep(addressDTO.cep())
                .state(addressDTO.estado())
                .street(addressDTO.rua())
                .city(addressDTO.cidade())
                .build();
        out.printf("Dados recuperados com sucesso: %s - %s - %s - %s",
                address.cep, address.city, address.state, address.street
        );
        out.println();
        out.println(Thread.currentThread().getName());
    }
}
