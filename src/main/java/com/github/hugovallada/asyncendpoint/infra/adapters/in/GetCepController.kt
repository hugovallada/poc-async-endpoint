package com.github.hugovallada.asyncendpoint.infra.adapters.`in`

import com.github.hugovallada.asyncendpoint.application.port.`in`.GetCepUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/kotlin")
class GetCepControllerCoroutine {

    @Autowired
    lateinit var getcep: GetCepUseCase

    @GetMapping("/{cep}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    fun get(@PathVariable cep: String) {
        CoroutineScope(Dispatchers.IO).launch {
            getcep.execute(cep)
        }
    }

}