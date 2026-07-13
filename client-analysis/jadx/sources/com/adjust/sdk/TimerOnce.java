package com.adjust.sdk;

import java.lang.ref.WeakReference;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class TimerOnce {
    private Runnable command;
    private ILogger logger = AdjustFactory.getLogger();
    private String name;
    private WeakReference<CustomScheduledExecutor> scheduledExecutorWeakRef;
    private ScheduledFuture waitingTask;

    public TimerOnce(CustomScheduledExecutor scheduler, Runnable command, String name) {
        this.name = name;
        this.scheduledExecutorWeakRef = new WeakReference<>(scheduler);
        this.command = command;
    }

    public void startIn(long fireIn) {
        cancel(false);
        CustomScheduledExecutor scheduledExecutor = this.scheduledExecutorWeakRef.get();
        if (scheduledExecutor != null) {
            String fireInSeconds = Util.SecondsDisplayFormat.format(fireIn / 1000.0d);
            this.logger.verbose("%s starting. Launching in %s seconds", this.name, fireInSeconds);
            this.waitingTask = scheduledExecutor.schedule(new Runnable() { // from class: com.adjust.sdk.TimerOnce.1
                @Override // java.lang.Runnable
                public void run() {
                    TimerOnce.this.logger.verbose("%s fired", TimerOnce.this.name);
                    TimerOnce.this.command.run();
                    TimerOnce.this.waitingTask = null;
                }
            }, fireIn, TimeUnit.MILLISECONDS);
        }
    }

    public long getFireIn() {
        if (this.waitingTask == null) {
            return 0L;
        }
        return this.waitingTask.getDelay(TimeUnit.MILLISECONDS);
    }

    private void cancel(boolean mayInterruptIfRunning) {
        if (this.waitingTask != null) {
            this.waitingTask.cancel(mayInterruptIfRunning);
        }
        this.waitingTask = null;
        this.logger.verbose("%s canceled", this.name);
    }

    public void cancel() {
        cancel(false);
    }

    public void teardown() {
        cancel(true);
        if (this.scheduledExecutorWeakRef != null) {
            this.scheduledExecutorWeakRef.clear();
        }
        this.scheduledExecutorWeakRef = null;
    }
}
