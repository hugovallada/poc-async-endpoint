package com.github.hugovallada.asyncendpoint.infra.adapters.out;

import com.github.hugovallada.asyncendpoint.application.port.out.ErrorEventPublisherOutputPort;
import org.springframework.context.ApplicationEventPublisher;

public class ErrorEventPublisherOutputAdapter implements ErrorEventPublisherOutputPort {
    private final ApplicationEventPublisher publisher;

    public ErrorEventPublisherOutputAdapter(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public void execute(String errorMessage) {
        publisher.publishEvent(errorMessage);
    }

}
