package com.github.hugovallada.asyncendpoint.application.port.out

fun interface LogWriterOutputPort {
    fun write(payload: String)
}
