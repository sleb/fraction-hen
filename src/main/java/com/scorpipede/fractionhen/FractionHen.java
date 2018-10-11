package com.scorpipede.fractionhen;

import com.amazon.ask.Skill;
import com.amazon.ask.Skills;
import com.scorpipede.fractionhen.handlers.*;

import javax.inject.Inject;

public class FractionHen {
    private final FallbackIntentHandler fallbackIntentHandler;
    private final GetLcmIntentHandler getLcmIntentHandler;
    private final HelpIntentHandler helpIntentHandler;
    private final LaunchRequestHandler launchRequestHandler;
    private final StopAndCancelIntentHandler stopAndCancelIntentHandler;

    @Inject
    public FractionHen(
        FallbackIntentHandler fallbackIntentHandler,
        GetLcmIntentHandler getLcmIntentHandler,
        HelpIntentHandler helpIntentHandler,
        LaunchRequestHandler launchRequestHandler,
        StopAndCancelIntentHandler stopAndCancelIntentHandler
    ) {
        this.fallbackIntentHandler = fallbackIntentHandler;
        this.getLcmIntentHandler = getLcmIntentHandler;
        this.helpIntentHandler = helpIntentHandler;
        this.launchRequestHandler = launchRequestHandler;
        this.stopAndCancelIntentHandler = stopAndCancelIntentHandler;
    }

    Skill getSkill() {
        return Skills.standard()
            .withSkillId("amzn1.ask.skill.da522fad-d397-4297-9c14-ac9f8e09e4fa")
            .addRequestHandler(fallbackIntentHandler)
            .addRequestHandler(getLcmIntentHandler)
            .addRequestHandler(helpIntentHandler)
            .addRequestHandler(launchRequestHandler)
            .addRequestHandler(stopAndCancelIntentHandler)
            .build();
    }
}
