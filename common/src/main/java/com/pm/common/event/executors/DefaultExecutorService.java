package com.pm.common.event.executors;

import com.pm.common.dto.event.Event;
import com.pm.common.event.EventTask;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.function.Supplier;

@Getter
public class DefaultExecutorService<T, V> implements PlatformExecutorService<T, V> {

    private List<EventTask<T, V>> eventTasks;

    private static final int DEFAULT_THREAD_POOL_SIZE = 5;
    private int threadPoolSize;
    {
        threadPoolSize = DEFAULT_THREAD_POOL_SIZE;
    }

    @Override
    public List<T> executeAll() throws ExecutionException, InterruptedException {
        return execute(eventTasks);
    }

    @Override
    public void populateEvent(Event<V> event) {
        getEventTasks().forEach(
                evenTask -> evenTask.setEvent(event)
        );
    }

    protected List<T> execute(List<? extends Callable<T>> tasks) throws ExecutionException, InterruptedException {
        final ExecutorService executorService = getExecutorService();
        final List<Future<T>> submittedTasks = new ArrayList<>();
        tasks.stream()
                .forEach(task -> {
                    final Future<T> future = executorService.submit(task);
                    submittedTasks.add(future);
                });

        final List<T> results = new ArrayList<>();

        for (Future<T> future : submittedTasks) {

            try {

                final T resultObj = future.get();

                if(resultObj != null){
                    results.add(resultObj);
                }

            } catch (final Exception e) {
            }

        }

        return results;

    }

    protected ExecutorService getExecutorService() {
        return Executors.newFixedThreadPool(getThreadPoolSize());
    }

    private int getThreadPoolSize() {
        return threadPoolSize;
    }
    // Setter method for eventTasks
    public void setEventTasks(List<EventTask<T, V>> eventTasks) {
        this.eventTasks = eventTasks;
    }

}
