package com.github.hugovallada.asyncendpoint.infra.config;

import com.github.hugovallada.asyncendpoint.application.port.out.GetCepOutputPort;
import com.github.hugovallada.asyncendpoint.infra.adapters.out.GetCepOutputAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OutputAdaptersConfig {

    @Bean
    public GetCepOutputPort getCepOutputPort() {
        return new GetCepOutputAdapter();
    }


}
