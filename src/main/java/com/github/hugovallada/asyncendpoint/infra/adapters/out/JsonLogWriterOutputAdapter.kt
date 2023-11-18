package com.github.hugovallada.asyncendpoint.infra.adapters.out

import com.fasterxml.jackson.databind.ObjectMapper
import com.github.hugovallada.asyncendpoint.application.port.out.LogWriterOutputPort
import java.io.File
import java.time.LocalDateTime

class JsonLogWriterOutputAdapter(private val jsonMapper: ObjectMapper) : LogWriterOutputPort {

    override fun write(payload: String) {
        val date = LocalDateTime.now()
        val file = File("/home/hugo/Documents/log-${date.dayOfMonth}-${date.month.value}-${date.year}.json")
        file.createNewFile()
        val payloadData = Payload(date.toString(), "error", payload)
        writeTextAsJsonList(file, jsonMapper.writeValueAsString(payloadData))
    }

    private fun writeTextAsJsonList(file: File, message: String) {
        val txt = file.readText()
        val newTxt = txt.replace("]", "").replace("[", "")
        val updatedTxt = if (newTxt.isEmpty()) {
            newTxt.plus("\n$message")
        } else {
            newTxt.plus(",\n$message")
        }
        file.writeText("[$updatedTxt\n]")
    }
}

data class Payload(
    val date: String,
    val status: String,
    val message: String
)
