package com.adjust.sdk;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class CustomScheduledExecutor {
    private ScheduledThreadPoolExecutor executor;
    private String source;

    public CustomScheduledExecutor(final String source) {
        this.executor = new ScheduledThreadPoolExecutor(1, new ThreadFactory() { // from class: com.adjust.sdk.CustomScheduledExecutor.1
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread thread = Executors.defaultThreadFactory().newThread(runnable);
                thread.setPriority(1);
                thread.setName(Constants.THREAD_PREFIX + thread.getName() + source);
                thread.setDaemon(true);
                thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: com.adjust.sdk.CustomScheduledExecutor.1.1
                    @Override // java.lang.Thread.UncaughtExceptionHandler
                    public void uncaughtException(Thread th, Throwable tr) {
                        AdjustFactory.getLogger().error("Thread %s with error %s", th.getName(), tr.getMessage());
                    }
                });
                return thread;
            }
        }, new RejectedExecutionHandler() { // from class: com.adjust.sdk.CustomScheduledExecutor.2
            @Override // java.util.concurrent.RejectedExecutionHandler
            public void rejectedExecution(Runnable runnable, ThreadPoolExecutor executor) {
                AdjustFactory.getLogger().warn("Runnable %s rejected from %s ", runnable.toString(), source);
            }
        });
        this.source = source;
        this.executor.setKeepAliveTime(10L, TimeUnit.MILLISECONDS);
        this.executor.allowCoreThreadTimeOut(true);
    }

    public Future<?> submit(Runnable task) {
        return this.executor.submit(task);
    }

    public void shutdownNow() {
        this.executor.shutdownNow();
    }

    public ScheduledFuture<?> scheduleWithFixedDelay(Runnable command, long initialDelay, long delay, TimeUnit unit) {
        return this.executor.scheduleWithFixedDelay(new RunnableWrapper(command), initialDelay, delay, unit);
    }

    public ScheduledFuture<?> schedule(Runnable command, long delay, TimeUnit unit) {
        return this.executor.schedule(new RunnableWrapper(command), delay, unit);
    }

    private class RunnableWrapper implements Runnable {
        private Runnable runnable;

        public RunnableWrapper(Runnable runnable) {
            this.runnable = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.runnable.run();
            } catch (Throwable t) {
                AdjustFactory.getLogger().error("Runnable error %s", t.getMessage());
            }
        }
    }
}
