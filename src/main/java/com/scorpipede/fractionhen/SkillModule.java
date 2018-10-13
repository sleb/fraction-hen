package com.scorpipede.fractionhen;

import com.amazon.ask.Skill;
import com.amazon.ask.Skills;
import com.scorpipede.fractionhen.handlers.*;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;

@Module
class SkillModule {
    @Reusable
    @Provides
    static Skill provideSkill(
        FallbackIntentHandler fallbackIntentHandler,
        GetLcmIntentHandler getLcmIntentHandler,
        HelpIntentHandler helpIntentHandler,
        LaunchRequestHandler launchRequestHandler,
        SimplifyFractionIntentHandler simplifyFractionIntentHandler,
        StopAndCancelIntentHandler stopAndCancelIntentHandler
    ) {
        return Skills.standard()
            .withSkillId("amzn1.ask.skill.da522fad-d397-4297-9c14-ac9f8e09e4fa")
            .addRequestHandler(fallbackIntentHandler)
            .addRequestHandler(getLcmIntentHandler)
            .addRequestHandler(helpIntentHandler)
            .addRequestHandler(launchRequestHandler)
            .addRequestHandler(simplifyFractionIntentHandler)
            .addRequestHandler(stopAndCancelIntentHandler)
            .build();
    }
}
