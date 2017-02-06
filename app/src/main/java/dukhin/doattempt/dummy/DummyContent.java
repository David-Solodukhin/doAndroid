package dukhin.doattempt.dummy;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<DummyItem> ITEMS = new ArrayList<DummyItem>();
    public static JSONArray doop = null;

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

    private static final int COUNT = 5;

    static { //static initialization block? why tho
        // Add some sample items.
        for (int i = 0; i < 1; i++) {
            //addItem(createDummyItem(i));
            if (doop != null) {
                try {
                    JSONObject event = doop.getJSONObject(i);
                    DummyItem temp = new DummyItem(i+"", event.getString("title"), event.getString("body"));
                    addItem(temp);
                } catch( JSONException e) {
                    e.printStackTrace();
                }
            } else {
                addItem(createDummyItem(i));
            }







        }
    }
    public static void updateDummies() {
        ITEM_MAP.clear();
        if (doop == null) {
            return;
        }
        for (int i = 0; i < doop.length(); i++) {
            try {
                JSONObject event = doop.getJSONObject(i);
                DummyItem temp = new DummyItem(i+"", event.getString("title"), event.getString("body"));
                addItem(temp);
            } catch( JSONException e) {
                e.printStackTrace();
            }
        }
    }
    private static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static DummyItem createDummyItem(int position) {



        return new DummyItem(String.valueOf(position), "Item " + position, makeDetails(position));
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class DummyItem {
        public final String id;
        public final String content;
        public final String details;

        public DummyItem(String id, String content, String details) {
            this.id = id;
            this.content = content;
            this.details = details;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}
