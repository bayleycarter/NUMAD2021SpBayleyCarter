package edu.neu.madcourse.numad21sp_bayleycarter;

import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.lang.Thread;

import androidx.appcompat.app.AppCompatActivity;


import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class MainActivity5 extends AppCompatActivity {

    private static final String TAG = "WebService Activity";

    private EditText editTextUrl;
    private TextView titleTextView;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        editTextUrl = (EditText) findViewById(R.id.URL_editText);
        titleTextView = (TextView) findViewById(R.id.resultTitle);
        btn = (Button) findViewById(R.id.convertButton);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callWebserviceButtonHandler(v);
            }
        });

    }

    public void callWebserviceButtonHandler(View view){
        PingWebServiceTask task = new PingWebServiceTask();

        task.execute();


    }

    private class PingWebServiceTask extends AsyncTask<String, Integer, JSONObject> {

        @Override
        protected void onProgressUpdate(Integer... values) {
            Log.i(TAG, "Progress ongoing");
        }

        @Override
        protected JSONObject doInBackground(String... params) {


            JSONObject jObject = new JSONObject();
            try {

                Uri.Builder builder = new Uri.Builder();
                builder.scheme("https")
                        .authority("www.omdbapi.com")
                        .appendQueryParameter("apikey", "fda7f7f9")
                        .appendQueryParameter("t", editTextUrl.getText().toString());
                URL url = new URL(builder.build().toString());

                String resp = NetworkUtil.httpResponse(url);
                jObject = new JSONObject(resp);

                return jObject;

            } catch (MalformedURLException e) {
                Log.e(TAG, "MalformedURLException");
                e.printStackTrace();
            } catch (ProtocolException e) {
                Log.e(TAG, "ProtocolException");
                e.printStackTrace();
            } catch (IOException e) {
                Log.e(TAG, "IOException");
                e.printStackTrace();
            } catch (JSONException e) {
                Log.e(TAG, "JSONException");
                e.printStackTrace();
            }

            return jObject;
        }

        @Override
        protected void onPostExecute(JSONObject jObject) {
            super.onPostExecute(jObject);
            TextView resultTitle = (TextView)findViewById(R.id.resultTitle);
            TextView resultYear = (TextView)findViewById(R.id.resultYear);
            TextView resultRating = (TextView)findViewById(R.id.resultRating);

            try {
                String movieTitle = jObject.getString("Title");
                String movieYear = jObject.getString("Year");
                String movieRating = jObject.getString("Rated");
                resultTitle.setText("Title: " + movieTitle);
                resultYear.setText("Year Released: " + movieYear);
                resultRating.setText("Rating: " + movieRating);
            } catch (JSONException e) {
                resultTitle.setText("Sorry, we couldn't find a movie with that name!");
                resultYear.setText("");
                resultRating.setText("");
            }

        }


    }
}