package com.scorpipede.fractionhen.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.LaunchRequest;
import com.amazon.ask.model.Response;
import dagger.Reusable;

import javax.inject.Inject;
import java.util.Optional;

import static com.amazon.ask.request.Predicates.requestType;
import static com.scorpipede.fractionhen.util.Prompts.WELCOME;

@Reusable
public class LaunchRequestHandler implements RequestHandler {

    @Inject
    LaunchRequestHandler() {
    }

    @Override
    public boolean canHandle(HandlerInput handlerInput) {
        return handlerInput.matches(requestType(LaunchRequest.class));
    }

    @Override
    public Optional<Response> handle(HandlerInput handlerInput) {
        return handlerInput.getResponseBuilder()
            .withShouldEndSession(false)
            .withSpeech(WELCOME)
            .build();
    }
}
