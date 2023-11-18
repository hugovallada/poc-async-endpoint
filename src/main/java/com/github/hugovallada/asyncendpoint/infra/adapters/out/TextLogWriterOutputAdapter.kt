package com.github.hugovallada.asyncendpoint.infra.adapters.out

import com.github.hugovallada.asyncendpoint.application.port.out.LogWriterOutputPort
import java.io.File
import java.time.LocalDateTime

class TextLogWriterOutputAdapter : LogWriterOutputPort {

    override fun write(payload: String) {
        val date = LocalDateTime.now()
        val file = File("/home/hugo/Documents/log-${date.dayOfMonth}-${date.month.value}-${date.year}.txt")
        file.createNewFile()
        file.appendText("\n$date - $payload,")
    }

}
