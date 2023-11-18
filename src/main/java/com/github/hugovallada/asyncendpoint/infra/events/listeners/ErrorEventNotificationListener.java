package com.github.hugovallada.asyncendpoint.infra.events.listeners;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ErrorEventNotificationListener {

    @EventListener
    public void execute(String eventMsg) {
        System.out.println("----------------------------***----------------------------");
        System.out.println("NOTIFICAÇÃO DE ERROR:");
        System.out.println(LocalDateTime.now());
        System.out.println(eventMsg);
        System.out.println("----------------------------***----------------------------");
    }

}
