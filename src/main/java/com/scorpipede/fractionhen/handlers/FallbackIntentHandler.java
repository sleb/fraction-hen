package com.scorpipede.fractionhen.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import dagger.Reusable;

import javax.inject.Inject;
import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;
import static com.scorpipede.fractionhen.util.Intents.FALLBACK;
import static com.scorpipede.fractionhen.util.Prompts.ERROR;

@Reusable
public class FallbackIntentHandler implements RequestHandler {

    @Inject
    FallbackIntentHandler() {}

    @Override
    public boolean canHandle(HandlerInput handlerInput) {
        return handlerInput.matches(intentName(FALLBACK));
    }

    @Override
    public Optional<Response> handle(HandlerInput handlerInput) {
        return handlerInput.getResponseBuilder()
            .withSpeech(ERROR)
            .withShouldEndSession(false)
            .build();
    }
}
