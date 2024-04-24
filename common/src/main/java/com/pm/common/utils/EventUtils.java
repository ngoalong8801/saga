package com.pm.common.utils;

import com.pm.common.converters.Converter;
import com.pm.common.dto.event.Event;
import com.pm.common.dto.event.Record;
import com.pm.common.event.EventService;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class EventUtils {
     public static <T extends Record> void publishEvent(T record,
                                                        final Class<? extends Event<T>> classz,
                                                        EventService eventService) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<? extends Event<T>> constructor = classz.getDeclaredConstructor(record.getClass());
        Event<T> event = constructor.newInstance(record);
        eventService.publishEvent(event);
    }
}
