package com.pm.common.event.executors;

import com.pm.common.dto.event.Event;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

public interface PlatformExecutorService<T, V>{
    List<T> executeAll() throws ExecutionException, InterruptedException;
    void populateEvent(Event<V> event);
}
