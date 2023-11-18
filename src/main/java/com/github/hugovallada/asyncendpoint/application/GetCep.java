package com.github.hugovallada.asyncendpoint.application;

import com.github.hugovallada.asyncendpoint.application.entity.Address;
import com.github.hugovallada.asyncendpoint.application.port.in.GetCepUseCase;
import com.github.hugovallada.asyncendpoint.application.port.out.GetCepOutputPort;

import static java.lang.System.out;

public class GetCep implements GetCepUseCase {
    private final GetCepOutputPort getCep;

    public GetCep(GetCepOutputPort getCep) {
        this.getCep = getCep;
    }

    @Override
    public void execute(String cep) {
        final var addressDTO = getCep.execute(cep);
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
