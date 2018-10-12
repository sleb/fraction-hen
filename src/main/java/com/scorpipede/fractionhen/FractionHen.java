package com.scorpipede.fractionhen;

import com.amazon.ask.Skill;
import dagger.Component;
import dagger.Reusable;

@Component(modules = SkillModule.class)
interface FractionHen {
    Skill skill();
}
