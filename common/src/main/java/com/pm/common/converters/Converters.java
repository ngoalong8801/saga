package com.pm.common.converters;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class Converters {
    public static <SOURCE, TARGET> List<TARGET> convertAll(final Collection<? extends SOURCE> sources,
                                                           final Converter<SOURCE, TARGET> converter) {
        if (sources == null || sources.isEmpty())
            return Collections.emptyList();
        final List<TARGET> result = new ArrayList<>();
        for (var source : sources)
            result.add(converter.convert(source));
        return result;
    }
}
