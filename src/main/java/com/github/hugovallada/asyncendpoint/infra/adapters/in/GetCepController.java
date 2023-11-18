package com.github.hugovallada.asyncendpoint.infra.adapters.in;

import com.github.hugovallada.asyncendpoint.application.port.in.GetCepApi;
import com.github.hugovallada.asyncendpoint.application.port.in.GetCepUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/cep")
public class GetCepController implements GetCepApi {

    private final GetCepUseCase getCepUseCase;

    public GetCepController(GetCepUseCase getCepUseCase) {
        this.getCepUseCase = getCepUseCase;
    }


    @Override
    @GetMapping("/{cep}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void execute(@PathVariable String cep) {
        CompletableFuture.runAsync(() -> getCepUseCase.execute(cep));
    }
}
