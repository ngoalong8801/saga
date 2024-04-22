package com.pm.common.converters;

import org.springframework.core.convert.ConversionException;

public interface Populator<SOURCE, TARGET>
{
    void populate(SOURCE source, TARGET target) throws ConversionException;
}
