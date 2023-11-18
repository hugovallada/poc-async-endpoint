package com.github.hugovallada.asyncendpoint.infra.adapters.`in`

import com.github.hugovallada.asyncendpoint.application.port.`in`.GetCepUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/kotlin")
class GetCepControllerCoroutine(private val getCep: GetCepUseCase) {
    @GetMapping("/{cep}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    fun get(@PathVariable cep: String) {
        CoroutineScope(Dispatchers.IO).launch {
            getCep.execute(cep)
        }
    }

}