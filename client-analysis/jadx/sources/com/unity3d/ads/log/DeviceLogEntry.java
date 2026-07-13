package com.unity3d.ads.log;

/* JADX INFO: loaded from: classes.dex */
class DeviceLogEntry {
    private DeviceLogLevel _logLevel;
    private String _originalMessage;
    private StackTraceElement _stackTraceElement;

    public DeviceLogEntry(DeviceLogLevel logLevel, String originalMessage, StackTraceElement stackTraceElement) {
        this._logLevel = null;
        this._originalMessage = null;
        this._stackTraceElement = null;
        this._logLevel = logLevel;
        this._originalMessage = originalMessage;
        this._stackTraceElement = stackTraceElement;
    }

    public DeviceLogLevel getLogLevel() {
        return this._logLevel;
    }

    public String getParsedMessage() {
        String message = this._originalMessage;
        String className = "UnknownClass";
        String methodName = "unknownMethod";
        int lineNumber = -1;
        if (this._stackTraceElement != null) {
            className = this._stackTraceElement.getClassName();
            methodName = this._stackTraceElement.getMethodName();
            lineNumber = this._stackTraceElement.getLineNumber();
        }
        if (message != null && !message.isEmpty()) {
            message = " :: " + message;
        }
        if (message == null) {
            message = "";
        }
        String lineNumberPart = " (line:" + lineNumber + ")";
        return className + "." + methodName + "()" + lineNumberPart + message;
    }
}
