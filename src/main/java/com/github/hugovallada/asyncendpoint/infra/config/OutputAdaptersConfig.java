package com.github.hugovallada.asyncendpoint.infra.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.hugovallada.asyncendpoint.application.port.out.ErrorEventPublisherOutputPort;
import com.github.hugovallada.asyncendpoint.application.port.out.GetCepOutputPort;
import com.github.hugovallada.asyncendpoint.application.port.out.LogWriterOutputPort;
import com.github.hugovallada.asyncendpoint.infra.adapters.out.ErrorEventPublisherOutputAdapter;
import com.github.hugovallada.asyncendpoint.infra.adapters.out.GetCepOutputAdapter;
import com.github.hugovallada.asyncendpoint.infra.adapters.out.JsonLogWriterOutputAdapter;
import com.github.hugovallada.asyncendpoint.infra.adapters.out.TextLogWriterOutputAdapter;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OutputAdaptersConfig {

    @Bean
    public GetCepOutputPort getCepOutputPort(ObjectMapper objectMapper) {
        return new GetCepOutputAdapter(objectMapper);
    }

    @Bean
    public ErrorEventPublisherOutputPort errorEventPublisherOutputPort(ApplicationEventPublisher publisher) {
        return new ErrorEventPublisherOutputAdapter(publisher);
    }

    @Bean(name = "text")
    public LogWriterOutputPort logWriterOutputPort() {
        return new TextLogWriterOutputAdapter();
    }

    @Bean(name = "json")
    public LogWriterOutputPort jsonWriterOutputPort(ObjectMapper objectMapper) {
        return new JsonLogWriterOutputAdapter(objectMapper);
    }

}
