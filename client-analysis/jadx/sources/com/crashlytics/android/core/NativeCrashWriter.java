package com.crashlytics.android.core;

import com.crashlytics.android.core.internal.models.BinaryImageData;
import com.crashlytics.android.core.internal.models.CustomAttributeData;
import com.crashlytics.android.core.internal.models.DeviceData;
import com.crashlytics.android.core.internal.models.SessionEventData;
import com.crashlytics.android.core.internal.models.SignalData;
import com.crashlytics.android.core.internal.models.ThreadData;
import io.fabric.sdk.android.Fabric;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
class NativeCrashWriter {
    static final String NDK_CRASH_TYPE = "ndk-crash";
    private static final SignalData DEFAULT_SIGNAL = new SignalData("", "", 0);
    private static final ProtobufMessage[] EMPTY_CHILDREN = new ProtobufMessage[0];
    private static final ThreadMessage[] EMPTY_THREAD_MESSAGES = new ThreadMessage[0];
    private static final FrameMessage[] EMPTY_FRAME_MESSAGES = new FrameMessage[0];
    private static final BinaryImageMessage[] EMPTY_BINARY_IMAGE_MESSAGES = new BinaryImageMessage[0];
    private static final CustomAttributeMessage[] EMPTY_CUSTOM_ATTRIBUTE_MESSAGES = new CustomAttributeMessage[0];

    NativeCrashWriter() {
    }

    private static abstract class ProtobufMessage {
        private final ProtobufMessage[] children;
        private final int tag;

        public ProtobufMessage(int tag, ProtobufMessage... children) {
            this.tag = tag;
            this.children = children == null ? NativeCrashWriter.EMPTY_CHILDREN : children;
        }

        public int getSize() {
            int size = getSizeNoTag();
            return size + CodedOutputStream.computeRawVarint32Size(size) + CodedOutputStream.computeTagSize(this.tag);
        }

        public int getSizeNoTag() {
            int size = getPropertiesSize();
            for (ProtobufMessage child : this.children) {
                size += child.getSize();
            }
            return size;
        }

        public void write(CodedOutputStream cos) throws IOException {
            cos.writeTag(this.tag, 2);
            cos.writeRawVarint32(getSizeNoTag());
            writeProperties(cos);
            for (ProtobufMessage child : this.children) {
                child.write(cos);
            }
        }

        public int getPropertiesSize() {
            return 0;
        }

        public void writeProperties(CodedOutputStream cos) throws IOException {
        }
    }

    private static final class RepeatedMessage extends ProtobufMessage {
        private final ProtobufMessage[] messages;

        public RepeatedMessage(ProtobufMessage... messages) {
            super(0, new ProtobufMessage[0]);
            this.messages = messages;
        }

        @Override // com.crashlytics.android.core.NativeCrashWriter.ProtobufMessage
        public void write(CodedOutputStream cos) throws IOException {
            for (ProtobufMessage message : this.messages) {
                message.write(cos);
            }
        }

        @Override // com.crashlytics.android.core.NativeCrashWriter.ProtobufMessage
        public int getSize() {
            int size = 0;
            for (ProtobufMessage message : this.messages) {
                size += message.getSize();
            }
            return size;
        }
    }

    private static final class NullMessage extends ProtobufMessage {
        public NullMessage() {
            super(0, new ProtobufMessage[0]);
        }

        @Override // com.crashlytics.android.core.NativeCrashWriter.ProtobufMessage
        public void write(CodedOutputStream cos) throws IOException {
        }

        @Override // com.crashlytics.android.core.NativeCrashWriter.ProtobufMessage
        public int getSize() {
            return 0;
        }
    }

    private static final class EventMessage extends ProtobufMessage {
        private static final int PROTOBUF_TAG = 10;
        private final String crashType;
        private final long time;

        public EventMessage(long time, String crashType, ProtobufMessage... eventMessages) {
            super(10, eventMessages);
            this.time = time;
            this.crashType = crashType;
        }

        @Override // com.crashlytics.android.core.NativeCrashWriter.ProtobufMessage
        public int getPropertiesSize() {
            int timeSize = CodedOutputStream.computeUInt64Size(1, this.time);
            int typeSize = CodedOutputStream.computeBytesSize(2, ByteString.copyFromUtf8(this.crashType));
            return timeSize + typeSize;
        }

        @Override // com.crashlytics.android.core.NativeCrashWriter.ProtobufMessage
        public void writeProperties(CodedOutputStream cos) throws IOException {
            cos.writeUInt64(1, this.time);
            cos.writeBytes(2, ByteString.copyFromUtf8(this.crashType));
        }
    }

    private static final class DeviceMessage extends ProtobufMessage {
        private static final int PROTOBUF_TAG = 5;
        private final float batteryLevel;
        private final int batteryVelocity;
        private final long diskUsed;
        private final int orientation;
        private final boolean proximityOn;
        private final long ramUsed;

        public DeviceMessage(float batteryLevel, int batteryVelocity, boolean proximityOn, int orientation, long ramUsed, long diskUsed) {
            super(5, new ProtobufMessage[0]);
            this.batteryLevel = batteryLevel;
            this.batteryVelocity = batteryVelocity;
            this.proximityOn = proximityOn;
            this.orientation = orientation;
            this.ramUsed = ramUsed;
            this.diskUsed = diskUsed;
        }

        @Override // com.crashlytics.android.core.NativeCrashWriter.ProtobufMessage
        public int getPropertiesSize() {
            int size = 0 + CodedOutputStream.computeFloatSize(1, this.batteryLevel);
            return size + CodedOutputStream.computeSInt32Size(2, this.batteryVelocity) + CodedOutputStream.computeBoolSize(3, this.proximityOn) + CodedOutputStream.computeUInt32Size(4, this.orientation) + CodedOutputStream.computeUInt64Size(5, this.ramUsed) + CodedOutputStream.computeUInt64Size(6, this.diskUsed);
        }

        @Override // com.crashlytics.android.core.NativeCrashWriter.ProtobufMessage
        public void writeProperties(CodedOutputStream cos) throws IOException {
            cos.writeFloat(1, this.batteryLevel);
            cos.writeSInt32(2, this.batteryVelocity);
            cos.writeBool(3, this.proximityOn);
            cos.writeUInt32(4, this.orientation);
            cos.writeUInt64(5, this.ramUsed);
            cos.writeUInt64(6, this.diskUsed);
        }
    }

    private static final class LogMessage extends ProtobufMessage {
        private static final int PROTOBUF_TAG = 6;
        ByteString logBytes;

        public LogMessage(ByteString logBytes) {
            super(6, new ProtobufMessage[0]);
            this.logBytes = logBytes;
        }

        @Override // com.crashlytics.android.core.NativeCrashWriter.ProtobufMessage
        public int getPropertiesSize() {
            return CodedOutputStream.computeBytesSize(1, this.logBytes);
        }

        @Override // com.crashlytics.android.core.NativeCrashWriter.ProtobufMessage
        public void writeProperties(CodedOutputStream cos) throws IOException {
            cos.writeBytes(1, this.logBytes);
        }
    }

    private static final class ApplicationMessage extends ProtobufMessage {
        private static final int PROTOBUF_TAG = 3;

        public ApplicationMessage(ExecutionMessage executionMessage, RepeatedMessage customAttrs) {
            super(3, executionMessage, customAttrs);
        }
    }

    private static final class ExecutionMessage extends ProtobufMessage {
        private static final int PROTOBUF_TAG = 1;

        public ExecutionMessage(SignalMessage signalMessage, RepeatedMessage threads, RepeatedMessage binaryImages) {
            super(1, threads, signalMessage, binaryImages);
        }
    }

    private static final class ThreadMessage extends ProtobufMessage {
        private static final int PROTOBUF_TAG = 1;
        private final int importance;
        private final String name;

        public ThreadMessage(ThreadData threadData, RepeatedMessage frames) {
            super(1, frames);
            this.name = threadData.name;
            this.importance = threadData.importance;
        }

        @Override // com.crashlytics.android.core.NativeCrashWriter.ProtobufMessage
        public int getPropertiesSize() {
            int nameSize = hasName() ? CodedOutputStream.computeBytesSize(1, ByteString.copyFromUtf8(this.name)) : 0;
            return CodedOutputStream.computeUInt32Size(2, this.importance) + nameSize;
        }

        @Override // com.crashlytics.android.core.NativeCrashWriter.ProtobufMessage
        public void writeProperties(CodedOutputStream cos) throws IOException {
            if (hasName()) {
                cos.writeBytes(1, ByteString.copyFromUtf8(this.name));
            }
            cos.writeUInt32(2, this.importance);
        }

        private boolean hasName() {
            return this.name != null && this.name.length() > 0;
        }
    }

    private static final class FrameMessage extends ProtobufMessage {
        private static final int PROTOBUF_TAG = 3;
        private final long address;
        private final String file;
        private final int importance;
        private final long offset;
        private final String symbol;

        public FrameMessage(ThreadData.FrameData frameData) {
            super(3, new ProtobufMessage[0]);
            this.address = frameData.address;
            this.symbol = frameData.symbol;
            this.file = frameData.file;
            this.offset = frameData.offset;
            this.importance = frameData.importance;
        }

        @Override // com.crashlytics.android.core.NativeCrashWriter.ProtobufMessage
        public int getPropertiesSize() {
            int size = CodedOutputStream.computeUInt64Size(1, this.address);
            return size + CodedOutputStream.computeBytesSize(2, ByteString.copyFromUtf8(this.symbol)) + CodedOutputStream.computeBytesSize(3, ByteString.copyFromUtf8(this.file)) + CodedOutputStream.computeUInt64Size(4, this.offset) + CodedOutputStream.computeUInt32Size(5, this.importance);
        }

        @Override // com.crashlytics.android.core.NativeCrashWriter.ProtobufMessage
        public void writeProperties(CodedOutputStream cos) throws IOException {
            cos.writeUInt64(1, this.address);
            cos.writeBytes(2, ByteString.copyFromUtf8(this.symbol));
            cos.writeBytes(3, ByteString.copyFromUtf8(this.file));
            cos.writeUInt64(4, this.offset);
            cos.writeUInt32(5, this.importance);
        }
    }

    private static final class SignalMessage extends ProtobufMessage {
        private static final int PROTOBUF_TAG = 3;
        private final long sigAddr;
        private final String sigCode;
        private final String sigName;

        public SignalMessage(SignalData signalData) {
            super(3, new ProtobufMessage[0]);
            this.sigName = signalData.name;
            this.sigCode = signalData.code;
            this.sigAddr = signalData.faultAddress;
        }

        @Override // com.crashlytics.android.core.NativeCrashWriter.ProtobufMessage
        public int getPropertiesSize() {
            int size = CodedOutputStream.computeBytesSize(1, ByteString.copyFromUtf8(this.sigName));
            return size + CodedOutputStream.computeBytesSize(2, ByteString.copyFromUtf8(this.sigCode)) + CodedOutputStream.computeUInt64Size(3, this.sigAddr);
        }

        @Override // com.crashlytics.android.core.NativeCrashWriter.ProtobufMessage
        public void writeProperties(CodedOutputStream cos) throws IOException {
            cos.writeBytes(1, ByteString.copyFromUtf8(this.sigName));
            cos.writeBytes(2, ByteString.copyFromUtf8(this.sigCode));
            cos.writeUInt64(3, this.sigAddr);
        }
    }

    private static final class BinaryImageMessage extends ProtobufMessage {
        private static final int PROTOBUF_TAG = 4;
        private final long baseAddr;
        private final String filePath;
        private final long imageSize;
        private final String uuid;

        public BinaryImageMessage(BinaryImageData binaryImageData) {
            super(4, new ProtobufMessage[0]);
            this.baseAddr = binaryImageData.baseAddress;
            this.imageSize = binaryImageData.size;
            this.filePath = binaryImageData.path;
            this.uuid = binaryImageData.id;
        }

        @Override // com.crashlytics.android.core.NativeCrashWriter.ProtobufMessage
        public int getPropertiesSize() {
            int addrSize = CodedOutputStream.computeUInt64Size(1, this.baseAddr);
            int imgSize = CodedOutputStream.computeUInt64Size(2, this.imageSize);
            int pathSize = CodedOutputStream.computeBytesSize(3, ByteString.copyFromUtf8(this.filePath));
            int uuidSize = CodedOutputStream.computeBytesSize(4, ByteString.copyFromUtf8(this.uuid));
            return pathSize + addrSize + imgSize + uuidSize;
        }

        @Override // com.crashlytics.android.core.NativeCrashWriter.ProtobufMessage
        public void writeProperties(CodedOutputStream cos) throws IOException {
            cos.writeUInt64(1, this.baseAddr);
            cos.writeUInt64(2, this.imageSize);
            cos.writeBytes(3, ByteString.copyFromUtf8(this.filePath));
            cos.writeBytes(4, ByteString.copyFromUtf8(this.uuid));
        }
    }

    private static final class CustomAttributeMessage extends ProtobufMessage {
        private static final int PROTOBUF_TAG = 2;
        private final String key;
        private final String value;

        public CustomAttributeMessage(CustomAttributeData customAttributeData) {
            super(2, new ProtobufMessage[0]);
            this.key = customAttributeData.key;
            this.value = customAttributeData.value;
        }

        @Override // com.crashlytics.android.core.NativeCrashWriter.ProtobufMessage
        public int getPropertiesSize() {
            int size = CodedOutputStream.computeBytesSize(1, ByteString.copyFromUtf8(this.key));
            return size + CodedOutputStream.computeBytesSize(2, ByteString.copyFromUtf8(this.value == null ? "" : this.value));
        }

        @Override // com.crashlytics.android.core.NativeCrashWriter.ProtobufMessage
        public void writeProperties(CodedOutputStream cos) throws IOException {
            cos.writeBytes(1, ByteString.copyFromUtf8(this.key));
            cos.writeBytes(2, ByteString.copyFromUtf8(this.value == null ? "" : this.value));
        }
    }

    private static EventMessage createEventMessage(SessionEventData crashEvent, LogFileManager logFileManager, Map<String, String> attributes) throws IOException {
        SignalData signal = crashEvent.signal != null ? crashEvent.signal : DEFAULT_SIGNAL;
        SignalMessage signalMessage = new SignalMessage(signal);
        RepeatedMessage threadsMessage = createThreadsMessage(crashEvent.threads);
        RepeatedMessage binaryImagesMessage = createBinaryImagesMessage(crashEvent.binaryImages);
        ExecutionMessage executionMessage = new ExecutionMessage(signalMessage, threadsMessage, binaryImagesMessage);
        RepeatedMessage customAttributesMessage = createCustomAttributesMessage(mergeCustomAttributes(crashEvent.customAttributes, attributes));
        ApplicationMessage applicationMessage = new ApplicationMessage(executionMessage, customAttributesMessage);
        ProtobufMessage deviceMessage = createDeviceMessage(crashEvent.deviceData);
        ByteString logByteString = logFileManager.getByteStringForLog();
        if (logByteString == null) {
            Fabric.getLogger().d(CrashlyticsCore.TAG, "No log data to include with this event.");
        }
        logFileManager.clearLog();
        ProtobufMessage logMessage = logByteString != null ? new LogMessage(logByteString) : new NullMessage();
        return new EventMessage(crashEvent.timestamp, NDK_CRASH_TYPE, applicationMessage, deviceMessage, logMessage);
    }

    private static CustomAttributeData[] mergeCustomAttributes(CustomAttributeData[] ndkAttributes, Map<String, String> javaAttributes) {
        Map<String, String> sorted = new TreeMap<>(javaAttributes);
        if (ndkAttributes != null) {
            for (CustomAttributeData attr : ndkAttributes) {
                sorted.put(attr.key, attr.value);
            }
        }
        Map.Entry<String, String>[] entryArray = (Map.Entry[]) sorted.entrySet().toArray(new Map.Entry[sorted.size()]);
        CustomAttributeData[] merged = new CustomAttributeData[entryArray.length];
        for (int i = 0; i < merged.length; i++) {
            merged[i] = new CustomAttributeData(entryArray[i].getKey(), entryArray[i].getValue());
        }
        return merged;
    }

    private static ProtobufMessage createDeviceMessage(DeviceData deviceData) {
        return deviceData == null ? new NullMessage() : new DeviceMessage(deviceData.batteryCapacity / 100.0f, deviceData.batteryVelocity, deviceData.proximity, deviceData.orientation, deviceData.totalPhysicalMemory - deviceData.availablePhysicalMemory, deviceData.totalInternalStorage - deviceData.availableInternalStorage);
    }

    private static RepeatedMessage createThreadsMessage(ThreadData[] threads) {
        ThreadMessage[] threadMessages = threads != null ? new ThreadMessage[threads.length] : EMPTY_THREAD_MESSAGES;
        for (int threadIdx = 0; threadIdx < threadMessages.length; threadIdx++) {
            ThreadData threadData = threads[threadIdx];
            threadMessages[threadIdx] = new ThreadMessage(threadData, createFramesMessage(threadData.frames));
        }
        return new RepeatedMessage(threadMessages);
    }

    private static RepeatedMessage createFramesMessage(ThreadData.FrameData[] frames) {
        FrameMessage[] frameMessages = frames != null ? new FrameMessage[frames.length] : EMPTY_FRAME_MESSAGES;
        for (int frameIdx = 0; frameIdx < frameMessages.length; frameIdx++) {
            frameMessages[frameIdx] = new FrameMessage(frames[frameIdx]);
        }
        return new RepeatedMessage(frameMessages);
    }

    private static RepeatedMessage createBinaryImagesMessage(BinaryImageData[] binaryImages) {
        BinaryImageMessage[] binaryImageMessages = binaryImages != null ? new BinaryImageMessage[binaryImages.length] : EMPTY_BINARY_IMAGE_MESSAGES;
        for (int i = 0; i < binaryImageMessages.length; i++) {
            binaryImageMessages[i] = new BinaryImageMessage(binaryImages[i]);
        }
        return new RepeatedMessage(binaryImageMessages);
    }

    private static RepeatedMessage createCustomAttributesMessage(CustomAttributeData[] customAttributes) {
        CustomAttributeMessage[] customAttributeMessages = customAttributes != null ? new CustomAttributeMessage[customAttributes.length] : EMPTY_CUSTOM_ATTRIBUTE_MESSAGES;
        for (int i = 0; i < customAttributeMessages.length; i++) {
            customAttributeMessages[i] = new CustomAttributeMessage(customAttributes[i]);
        }
        return new RepeatedMessage(customAttributeMessages);
    }

    public static void writeNativeCrash(SessionEventData crashEventData, LogFileManager logFileManager, Map<String, String> customAttributes, CodedOutputStream cos) throws IOException {
        EventMessage crashEventMessage = createEventMessage(crashEventData, logFileManager, customAttributes);
        crashEventMessage.write(cos);
    }
}
