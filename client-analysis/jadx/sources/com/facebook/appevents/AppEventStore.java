package com.facebook.appevents;

import android.content.Context;
import android.util.Log;
import com.facebook.FacebookSdk;
import com.facebook.internal.Utility;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;

/* JADX INFO: loaded from: classes.dex */
class AppEventStore {
    private static final String PERSISTED_EVENTS_FILENAME = "AppEventsLogger.persistedevents";
    private static final String TAG = AppEventStore.class.getName();

    AppEventStore() {
    }

    public static synchronized void persistEvents(AccessTokenAppIdPair accessTokenAppIdPair, SessionEventsState appEvents) {
        assertIsNotMainThread();
        PersistedEvents persistedEvents = readAndClearStore();
        if (persistedEvents.containsKey(accessTokenAppIdPair)) {
            persistedEvents.get(accessTokenAppIdPair).addAll(appEvents.getEventsToPersist());
        } else {
            persistedEvents.addEvents(accessTokenAppIdPair, appEvents.getEventsToPersist());
        }
        saveEventsToDisk(persistedEvents);
    }

    public static synchronized void persistEvents(AppEventCollection eventsToPersist) {
        assertIsNotMainThread();
        PersistedEvents persistedEvents = readAndClearStore();
        for (AccessTokenAppIdPair accessTokenAppIdPair : eventsToPersist.keySet()) {
            SessionEventsState sessionEventsState = eventsToPersist.get(accessTokenAppIdPair);
            persistedEvents.addEvents(accessTokenAppIdPair, sessionEventsState.getEventsToPersist());
        }
        saveEventsToDisk(persistedEvents);
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0033 A[Catch: all -> 0x005b, TRY_ENTER, TRY_LEAVE, TryCatch #7 {, blocks: (B:4:0x0003, B:7:0x0024, B:8:0x0027, B:11:0x0033, B:15:0x003b, B:34:0x007d, B:35:0x0080, B:36:0x0089, B:38:0x008b, B:28:0x0066, B:29:0x0069, B:32:0x0074, B:17:0x0045, B:18:0x0048, B:21:0x0053), top: B:50:0x0003, inners: #3, #4, #9, #10 }] */
    public static synchronized PersistedEvents readAndClearStore() {
        PersistedEvents persistedEvents;
        assertIsNotMainThread();
        MovedClassObjectInputStream ois = null;
        persistedEvents = null;
        Context context = FacebookSdk.getApplicationContext();
        try {
            try {
                InputStream is = context.openFileInput(PERSISTED_EVENTS_FILENAME);
                MovedClassObjectInputStream ois2 = new MovedClassObjectInputStream(new BufferedInputStream(is));
                try {
                    persistedEvents = (PersistedEvents) ois2.readObject();
                    Utility.closeQuietly(ois2);
                    try {
                        context.getFileStreamPath(PERSISTED_EVENTS_FILENAME).delete();
                        ois = ois2;
                    } catch (Exception ex) {
                        Log.w(TAG, "Got unexpected exception when removing events file: ", ex);
                        ois = ois2;
                    }
                } catch (FileNotFoundException e) {
                    ois = ois2;
                    Utility.closeQuietly(ois);
                    try {
                        context.getFileStreamPath(PERSISTED_EVENTS_FILENAME).delete();
                    } catch (Exception ex2) {
                        Log.w(TAG, "Got unexpected exception when removing events file: ", ex2);
                    }
                    if (persistedEvents == null) {
                        persistedEvents = new PersistedEvents();
                    }
                    return persistedEvents;
                } catch (Exception e2) {
                    e = e2;
                    ois = ois2;
                    Log.w(TAG, "Got unexpected exception while reading events: ", e);
                    Utility.closeQuietly(ois);
                    try {
                        context.getFileStreamPath(PERSISTED_EVENTS_FILENAME).delete();
                    } catch (Exception ex3) {
                        Log.w(TAG, "Got unexpected exception when removing events file: ", ex3);
                    }
                } catch (Throwable th) {
                    th = th;
                    ois = ois2;
                    Utility.closeQuietly(ois);
                    try {
                        context.getFileStreamPath(PERSISTED_EVENTS_FILENAME).delete();
                    } catch (Exception ex4) {
                        Log.w(TAG, "Got unexpected exception when removing events file: ", ex4);
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (FileNotFoundException e3) {
        } catch (Exception e4) {
            e = e4;
        }
        if (persistedEvents == null) {
            persistedEvents = new PersistedEvents();
        }
        return persistedEvents;
    }

    private static void saveEventsToDisk(PersistedEvents eventsToPersist) throws Throwable {
        ObjectOutputStream oos = null;
        Context context = FacebookSdk.getApplicationContext();
        try {
            try {
                ObjectOutputStream oos2 = new ObjectOutputStream(new BufferedOutputStream(context.openFileOutput(PERSISTED_EVENTS_FILENAME, 0)));
                try {
                    oos2.writeObject(eventsToPersist);
                    Utility.closeQuietly(oos2);
                } catch (Exception e) {
                    e = e;
                    oos = oos2;
                    Log.w(TAG, "Got unexpected exception while persisting events: ", e);
                    try {
                        context.getFileStreamPath(PERSISTED_EVENTS_FILENAME).delete();
                    } catch (Exception e2) {
                    }
                    Utility.closeQuietly(oos);
                } catch (Throwable th) {
                    th = th;
                    oos = oos2;
                    Utility.closeQuietly(oos);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static void assertIsNotMainThread() {
    }

    private static class MovedClassObjectInputStream extends ObjectInputStream {
        private static final String ACCESS_TOKEN_APP_ID_PAIR_SERIALIZATION_PROXY_V1_CLASS_NAME = "com.facebook.appevents.AppEventsLogger$AccessTokenAppIdPair$SerializationProxyV1";
        private static final String APP_EVENT_SERIALIZATION_PROXY_V1_CLASS_NAME = "com.facebook.appevents.AppEventsLogger$AppEvent$SerializationProxyV1";

        public MovedClassObjectInputStream(InputStream in) throws IOException {
            super(in);
        }

        @Override // java.io.ObjectInputStream
        protected ObjectStreamClass readClassDescriptor() throws ClassNotFoundException, IOException {
            ObjectStreamClass resultClassDescriptor = super.readClassDescriptor();
            if (resultClassDescriptor.getName().equals(ACCESS_TOKEN_APP_ID_PAIR_SERIALIZATION_PROXY_V1_CLASS_NAME)) {
                return ObjectStreamClass.lookup(AccessTokenAppIdPair.SerializationProxyV1.class);
            }
            if (resultClassDescriptor.getName().equals(APP_EVENT_SERIALIZATION_PROXY_V1_CLASS_NAME)) {
                return ObjectStreamClass.lookup(AppEvent.SerializationProxyV1.class);
            }
            return resultClassDescriptor;
        }
    }
}
