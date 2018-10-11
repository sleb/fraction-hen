package com.scorpipede.fractionhen;

import com.amazon.ask.AlexaSkill;
import com.amazon.ask.SkillStreamHandler;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class FractionHenLambda extends SkillStreamHandler {
    public FractionHenLambda() {
        super(getSkill());
    }

    private static AlexaSkill getSkill() {
        Injector injector = Guice.createInjector(new AppModule());
        return injector.getInstance(FractionHen.class).getSkill();
    }
}
