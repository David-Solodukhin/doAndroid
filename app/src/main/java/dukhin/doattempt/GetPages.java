package dukhin.doattempt;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import dukhin.doattempt.dummy.DummyContent;

class GetPages extends AsyncTask<String, Void, JSONArray> {

    private HttpURLConnection connection;
    private Context context;
    protected JSONArray doInBackground(String... urls) {
        StringBuilder buffer = new StringBuilder();
        JSONArray jArray = null;
        try {
            URL url = new URL("http://128.61.3.72:8000/sorttime&page=0&time=1619&uni=GT");
            connection = (HttpURLConnection) url.openConnection();
            connection.connect();

            InputStream stream = connection.getInputStream();

            BufferedReader reader = new BufferedReader(new InputStreamReader((stream)));
            String line = "";
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }
            jArray = new JSONArray(buffer.toString());

        }catch(Exception e) {
            e.printStackTrace();
        }
        return jArray;
    }
    public GetPages(Context context) {
        this.context = context;
    }
    protected void onPostExecute(JSONArray test) {
        // TODO: check this.exception
        // TODO: do something with the feed
        DummyContent.doop = test;
        DummyContent.ITEMS.clear();
        DummyContent.updateDummies();
        ((ItemListActivity) context).updateList();
        try {
            Log.d("k", test.getJSONObject(0).toString());
        } catch(Exception e) {

        }


    }
}