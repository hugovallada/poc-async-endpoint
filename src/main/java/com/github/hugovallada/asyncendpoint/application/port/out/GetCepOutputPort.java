package com.github.hugovallada.asyncendpoint.application.port.out;

import com.github.hugovallada.asyncendpoint.application.dto.AddressDTO;

@FunctionalInterface
public interface GetCepOutputPort {
    AddressDTO execute(String cep);
}
