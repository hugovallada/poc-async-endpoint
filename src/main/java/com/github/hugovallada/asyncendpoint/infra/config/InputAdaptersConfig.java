package com.github.hugovallada.asyncendpoint.infra.config;

import com.github.hugovallada.asyncendpoint.application.GetCep;
import com.github.hugovallada.asyncendpoint.application.port.in.GetCepUseCase;
import com.github.hugovallada.asyncendpoint.application.port.out.ErrorEventPublisherOutputPort;
import com.github.hugovallada.asyncendpoint.application.port.out.GetCepOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InputAdaptersConfig {

    @Bean
    public GetCepUseCase getCepUseCase(GetCepOutputPort getCepOutputPort, ErrorEventPublisherOutputPort errorEventPublisher) {
        return new GetCep(getCepOutputPort, errorEventPublisher);
    }

}
