package com.github.hugovallada.asyncendpoint.application.port.out;

import com.github.hugovallada.asyncendpoint.application.dto.AddressDTO;
import com.github.hugovallada.asyncendpoint.application.dto.Result;

@FunctionalInterface
public interface GetCepOutputPort {
    Result<AddressDTO, IllegalStateException> execute(String cep);
}
