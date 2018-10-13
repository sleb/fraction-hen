package com.scorpipede.fractionhen.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Intent;
import com.amazon.ask.model.IntentRequest;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.Slot;

import javax.inject.Inject;
import java.util.Map;
import java.util.Optional;

import static com.amazon.ask.model.DialogState.COMPLETED;
import static com.amazon.ask.request.Predicates.intentName;
import static com.scorpipede.fractionhen.util.Factors.gcd;
import static com.scorpipede.fractionhen.util.Intents.SIMPLIFY_FRACTION;
import static com.scorpipede.fractionhen.util.Prompts.SIMPLIFIED;
import static com.scorpipede.fractionhen.util.Slots.*;
import static java.lang.String.format;

public class SimplifyFractionIntentHandler implements RequestHandler {

    @Inject
    SimplifyFractionIntentHandler() {
    }

    @Override
    public boolean canHandle(HandlerInput handlerInput) {
        return handlerInput.matches(intentName(SIMPLIFY_FRACTION));
    }

    @Override
    public Optional<Response> handle(HandlerInput handlerInput) {
        IntentRequest intentRequest = (IntentRequest) handlerInput.getRequest();
        Intent intent = intentRequest.getIntent();

        if (intentRequest.getDialogState() == COMPLETED) {
            Map<String, Slot> slots = intent.getSlots();

            int numerator = parseInt(slots.get(NUMERATOR));
            int denominator = parseInt(slots.get(DENOMINATOR));
            int gcd = gcd(numerator, denominator);

            int simplifiedNumerator = numerator / gcd;
            int simplifiedDenominator = denominator / gcd;

            return handlerInput.getResponseBuilder()
                .withSpeech(
                    format(
                        SIMPLIFIED,
                        numerator, denominator, simplifiedNumerator, simplifiedDenominator
                    )
                )
                .withSimpleCard(
                    "Simplified Fraction",
                    format(
                        "%s/%s simplifies to %s/%s",
                        numerator, denominator, simplifiedNumerator, simplifiedDenominator
                    )
                )
                .build();
        } else {
            return handlerInput.getResponseBuilder()
                .addDelegateDirective(intent)
                .withShouldEndSession(true)
                .build();
        }
    }
}
