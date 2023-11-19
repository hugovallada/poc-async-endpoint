package com.github.hugovallada.asyncendpoint.application.port.out;

@FunctionalInterface
public interface ErrorEventPublisherOutputPort {
    void execute(String errorMessage);
}
