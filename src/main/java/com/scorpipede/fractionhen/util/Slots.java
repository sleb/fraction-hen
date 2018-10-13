package com.scorpipede.fractionhen.util;

import com.amazon.ask.model.Slot;

public interface Slots {
    String FIRST = "first";
    String SECOND = "second";

    String NUMERATOR = "numerator";
    String DENOMINATOR = "denominator";

    static int parseInt(Slot slot) {
        return Integer.parseInt(slot.getValue());
    }
}
