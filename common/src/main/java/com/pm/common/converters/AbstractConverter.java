package com.pm.common.converters;

import org.springframework.core.convert.ConversionException;

public abstract class AbstractConverter<SOURCE, TARGET>
    implements Converter<SOURCE, TARGET>, Populator<SOURCE, TARGET>
{

    @Override
    public TARGET convert(final SOURCE source) {
        final TARGET target = createFromClass();
        populate(source, target);
        return target;
    }

    @Override
    public TARGET convert(SOURCE source, TARGET target) throws ConversionException {
        populate(source, target);
        return target;
    }

    @Override
    public abstract void populate(final SOURCE source, final TARGET target);

    public abstract TARGET createFromClass();
}

