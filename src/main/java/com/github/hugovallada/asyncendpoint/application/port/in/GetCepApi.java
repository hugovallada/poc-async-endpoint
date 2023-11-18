package com.github.hugovallada.asyncendpoint.application.port.in;

@FunctionalInterface
public interface GetCepApi {
    void execute(String cep);
}
