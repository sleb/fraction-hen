package com.scorpipede.fractionhen.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Intent;
import com.amazon.ask.model.IntentRequest;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.Slot;
import dagger.Reusable;

import javax.inject.Inject;
import java.util.Map;
import java.util.Optional;

import static com.amazon.ask.model.DialogState.COMPLETED;
import static com.amazon.ask.request.Predicates.intentName;
import static com.scorpipede.fractionhen.util.Factors.lcm;
import static com.scorpipede.fractionhen.util.Intents.GET_LCM;
import static com.scorpipede.fractionhen.util.Prompts.LCM;
import static com.scorpipede.fractionhen.util.Slots.*;
import static java.lang.String.format;

@Reusable
public class GetLcmIntentHandler implements RequestHandler {

    @Inject
    GetLcmIntentHandler() {
    }

    @Override
    public boolean canHandle(HandlerInput handlerInput) {
        return handlerInput.matches(intentName(GET_LCM));
    }

    @Override
    public Optional<Response> handle(HandlerInput handlerInput) {
        IntentRequest intentRequest = (IntentRequest) handlerInput.getRequest();
        Intent intent = intentRequest.getIntent();

        if (intentRequest.getDialogState() == COMPLETED) {
            Map<String, Slot> slots = intent.getSlots();

            int first = parseInt(slots.get(FIRST));
            int second = parseInt(slots.get(SECOND));

            String prompt = format(LCM, first, second, lcm(first, second));

            return handlerInput.getResponseBuilder()
                .withSpeech(prompt)
                .withSimpleCard("Least Common Multiple", prompt)
                .withShouldEndSession(true)
                .build();
        } else {
            return handlerInput.getResponseBuilder()
                .addDelegateDirective(intent)
                .build();
        }
    }
}
