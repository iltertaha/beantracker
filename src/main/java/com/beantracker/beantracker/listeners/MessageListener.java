package com.beantracker.beantracker.listeners;

import discord4j.core.object.entity.Message;
import reactor.core.publisher.Mono;

public class MessageListener {

    private String sender = "STRANGER COFFEE ADDICT";

    public Mono<Void> processMessage(final Message eventMessage){
        return Mono.just(eventMessage)
                .filter(message -> {
                    final Boolean isNotBot = message.getAuthor()
                            .map(user -> !user.isBot())
                            .orElse(false);
                    if(isNotBot){
                        message.getAuthor().ifPresent(user -> {
                            sender = user.getUsername();
                        });
                    }
                    return isNotBot;
                })
                .flatMap(Message::getChannel)
                .flatMap(channel -> channel.createMessage(String.format("Hello '%s' ", sender)))
                .then();
    }

}