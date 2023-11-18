package com.github.hugovallada.asyncendpoint.infra.events.listeners;

import com.github.hugovallada.asyncendpoint.application.port.out.LogWriterOutputPort;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ErrorEventNotificationListener {

    private final LogWriterOutputPort logWriter;

    public ErrorEventNotificationListener(@Qualifier("json") LogWriterOutputPort logWriter) {
        this.logWriter = logWriter;
    }

    @EventListener
    public void execute(String eventMsg) {
        System.out.println("----------------------------***----------------------------");
        System.out.println("NOTIFICAÇÃO DE ERROR:");
        System.out.println(LocalDateTime.now());
        System.out.println(eventMsg);
        System.out.println("----------------------------***----------------------------");
        logWriter.write(eventMsg);
    }

}
