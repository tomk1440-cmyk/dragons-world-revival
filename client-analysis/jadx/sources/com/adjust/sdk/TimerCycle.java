package com.adjust.sdk;

import java.lang.ref.WeakReference;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class TimerCycle {
    private Runnable command;
    private long cycleDelay;
    private long initialDelay;
    private boolean isPaused = true;
    private ILogger logger = AdjustFactory.getLogger();
    private String name;
    private WeakReference<CustomScheduledExecutor> scheduledExecutorWeakRef;
    private ScheduledFuture waitingTask;

    public TimerCycle(CustomScheduledExecutor scheduler, Runnable command, long initialDelay, long cycleDelay, String name) {
        this.scheduledExecutorWeakRef = new WeakReference<>(scheduler);
        this.name = name;
        this.command = command;
        this.initialDelay = initialDelay;
        this.cycleDelay = cycleDelay;
        String cycleDelaySecondsString = Util.SecondsDisplayFormat.format(cycleDelay / 1000.0d);
        String initialDelaySecondsString = Util.SecondsDisplayFormat.format(initialDelay / 1000.0d);
        this.logger.verbose("%s configured to fire after %s seconds of starting and cycles every %s seconds", name, initialDelaySecondsString, cycleDelaySecondsString);
    }

    public void start() {
        if (!this.isPaused) {
            this.logger.verbose("%s is already started", this.name);
            return;
        }
        CustomScheduledExecutor scheduledExecutor = this.scheduledExecutorWeakRef.get();
        if (scheduledExecutor != null) {
            this.logger.verbose("%s starting", this.name);
            this.waitingTask = scheduledExecutor.scheduleWithFixedDelay(new Runnable() { // from class: com.adjust.sdk.TimerCycle.1
                @Override // java.lang.Runnable
                public void run() {
                    TimerCycle.this.logger.verbose("%s fired", TimerCycle.this.name);
                    TimerCycle.this.command.run();
                }
            }, this.initialDelay, this.cycleDelay, TimeUnit.MILLISECONDS);
            this.isPaused = false;
        }
    }

    public void suspend() {
        if (this.isPaused) {
            this.logger.verbose("%s is already suspended", this.name);
            return;
        }
        this.initialDelay = this.waitingTask.getDelay(TimeUnit.MILLISECONDS);
        this.waitingTask.cancel(false);
        String initialDelaySeconds = Util.SecondsDisplayFormat.format(this.initialDelay / 1000.0d);
        this.logger.verbose("%s suspended with %s seconds left", this.name, initialDelaySeconds);
        this.isPaused = true;
    }

    private void cancel(boolean mayInterruptIfRunning) {
        if (this.waitingTask != null) {
            this.waitingTask.cancel(mayInterruptIfRunning);
        }
        this.waitingTask = null;
    }

    public void teardown() {
        cancel(true);
        if (this.scheduledExecutorWeakRef != null) {
            this.scheduledExecutorWeakRef.clear();
        }
        this.scheduledExecutorWeakRef = null;
    }
}
