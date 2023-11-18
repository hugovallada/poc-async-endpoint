package com.github.hugovallada.asyncendpoint.application.port.in;

@FunctionalInterface
public interface GetCepUseCase {
    void execute(String cep);
}
