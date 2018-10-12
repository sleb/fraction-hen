package com.scorpipede.fractionhen.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.scorpipede.fractionhen.util.Intents;
import com.scorpipede.fractionhen.util.Prompts;
import dagger.Reusable;

import javax.inject.Inject;
import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;

@Reusable
public class HelpIntentHandler implements RequestHandler {

    @Inject
    HelpIntentHandler() {
    }

    @Override
    public boolean canHandle(HandlerInput handlerInput) {
        return handlerInput.matches(intentName(Intents.HELP));
    }

    @Override
    public Optional<Response> handle(HandlerInput handlerInput) {
        return handlerInput.getResponseBuilder()
            .withSpeech(Prompts.HELP)
            .withShouldEndSession(false)
            .build();
    }
}
