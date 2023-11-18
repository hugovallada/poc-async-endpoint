package com.github.hugovallada.asyncendpoint.application.port.out;

public interface ErrorEventPublisherOutputPort {
    void execute(String errorMessage);
}
