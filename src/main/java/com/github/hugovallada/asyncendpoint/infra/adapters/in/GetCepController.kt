package com.github.hugovallada.asyncendpoint.infra.adapters.`in`

import com.github.hugovallada.asyncendpoint.application.port.`in`.GetCepApi
import com.github.hugovallada.asyncendpoint.application.port.`in`.GetCepUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/kotlin")
class GetCepControllerCoroutine(private val getCep: GetCepUseCase) : GetCepApi {

    @GetMapping("/{cep}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    override fun execute(@PathVariable cep: String) {
        CoroutineScope(Dispatchers.IO).launch {
            getCep.execute(cep)
        }
    }

}
