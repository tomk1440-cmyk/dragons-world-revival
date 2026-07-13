package bolts;

/* JADX INFO: loaded from: classes.dex */
class UnobservedErrorNotifier {
    private Task<?> task;

    public UnobservedErrorNotifier(Task<?> task) {
        this.task = task;
    }

    protected void finalize() throws Throwable {
        Task.UnobservedExceptionHandler ueh;
        try {
            Task<?> task = this.task;
            if (task != null && (ueh = Task.getUnobservedExceptionHandler()) != null) {
                ueh.unobservedException(task, new UnobservedTaskException(task.getError()));
            }
        } finally {
            super.finalize();
        }
    }

    public void setObserved() {
        this.task = null;
    }
}
