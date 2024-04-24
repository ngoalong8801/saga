package com.pm.common.converters;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class Populators {
    public static <SOURCE, TARGET> void populateAll(SOURCE source, final Collection<? extends TARGET> targets,
                                                           final Populator<SOURCE, TARGET> populator) {
        if (source == null)
            return;
        for (var target: targets)
            populator.populate(source, target);
    }
}
