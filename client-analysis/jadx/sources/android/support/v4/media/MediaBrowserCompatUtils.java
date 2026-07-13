package android.support.v4.media;

import android.os.Bundle;
import com.google.android.gms.nearby.messages.Strategy;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MediaBrowserCompatUtils {
    public static boolean areSameOptions(Bundle options1, Bundle options2) {
        if (options1 == options2) {
            return true;
        }
        if (options1 == null) {
            return options2.getInt(MediaBrowserCompat.EXTRA_PAGE, -1) == -1 && options2.getInt(MediaBrowserCompat.EXTRA_PAGE_SIZE, -1) == -1;
        }
        if (options2 == null) {
            return options1.getInt(MediaBrowserCompat.EXTRA_PAGE, -1) == -1 && options1.getInt(MediaBrowserCompat.EXTRA_PAGE_SIZE, -1) == -1;
        }
        return options1.getInt(MediaBrowserCompat.EXTRA_PAGE, -1) == options2.getInt(MediaBrowserCompat.EXTRA_PAGE, -1) && options1.getInt(MediaBrowserCompat.EXTRA_PAGE_SIZE, -1) == options2.getInt(MediaBrowserCompat.EXTRA_PAGE_SIZE, -1);
    }

    public static boolean hasDuplicatedItems(Bundle options1, Bundle options2) {
        int startIndex1;
        int endIndex1;
        int startIndex2;
        int endIndex2;
        int page1 = options1 == null ? -1 : options1.getInt(MediaBrowserCompat.EXTRA_PAGE, -1);
        int page2 = options2 == null ? -1 : options2.getInt(MediaBrowserCompat.EXTRA_PAGE, -1);
        int pageSize1 = options1 == null ? -1 : options1.getInt(MediaBrowserCompat.EXTRA_PAGE_SIZE, -1);
        int pageSize2 = options2 == null ? -1 : options2.getInt(MediaBrowserCompat.EXTRA_PAGE_SIZE, -1);
        if (page1 == -1 || pageSize1 == -1) {
            startIndex1 = 0;
            endIndex1 = Strategy.TTL_SECONDS_INFINITE;
        } else {
            startIndex1 = pageSize1 * (page1 - 1);
            endIndex1 = (startIndex1 + pageSize1) - 1;
        }
        if (page2 == -1 || pageSize2 == -1) {
            startIndex2 = 0;
            endIndex2 = Strategy.TTL_SECONDS_INFINITE;
        } else {
            startIndex2 = pageSize2 * (page2 - 1);
            endIndex2 = (startIndex2 + pageSize2) - 1;
        }
        if (startIndex1 > startIndex2 || startIndex2 > endIndex1) {
            return startIndex1 <= endIndex2 && endIndex2 <= endIndex1;
        }
        return true;
    }

    public static List<MediaBrowserCompat.MediaItem> applyOptions(List<MediaBrowserCompat.MediaItem> list, Bundle options) {
        int page = options.getInt(MediaBrowserCompat.EXTRA_PAGE, -1);
        int pageSize = options.getInt(MediaBrowserCompat.EXTRA_PAGE_SIZE, -1);
        if (page != -1 || pageSize != -1) {
            int fromIndex = pageSize * (page - 1);
            int toIndex = fromIndex + pageSize;
            if (page < 1 || pageSize < 1 || fromIndex >= list.size()) {
                return null;
            }
            if (toIndex > list.size()) {
                toIndex = list.size();
            }
            return list.subList(fromIndex, toIndex);
        }
        return list;
    }
}
