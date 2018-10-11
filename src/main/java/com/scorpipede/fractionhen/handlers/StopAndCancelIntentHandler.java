package com.scorpipede.fractionhen.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;

import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;
import static com.scorpipede.fractionhen.util.Intents.CANCEL;
import static com.scorpipede.fractionhen.util.Intents.STOP;
import static com.scorpipede.fractionhen.util.Prompts.BYE;

public class StopAndCancelIntentHandler implements RequestHandler {

    @Override
    public boolean canHandle(HandlerInput handlerInput) {
        return handlerInput.matches(intentName(CANCEL).or(intentName(STOP)));
    }

    @Override
    public Optional<Response> handle(HandlerInput handlerInput) {
        return handlerInput.getResponseBuilder()
            .withSpeech(BYE)
            .withShouldEndSession(true)
            .build();
    }
}
