package com.pm.common.converters;

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
    public abstract void populate(final SOURCE source, final TARGET target);

    public abstract TARGET createFromClass();
}

