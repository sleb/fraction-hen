package com.scorpipede.fractionhen;

import com.amazon.ask.SkillStreamHandler;

public class FractionHenLambda extends SkillStreamHandler {
    public FractionHenLambda() {
        super(DaggerFractionHen.create().skill());
    }
}
