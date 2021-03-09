package edu.neu.madcourse.numad21sp_bayleycarter;

import android.net.Network;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class MainActivity5 extends AppCompatActivity {

    private static final String TAG = "WebService Activity";

    private EditText mURLEditText;
    private TextView mTitleTextView;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        mURLEditText = (EditText) findViewById(R.id.URL_editText);
        mTitleTextView = (TextView) findViewById(R.id.result_textView);
        btn = (Button) findViewById(R.id.convertButton);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                callWebserviceButtonHandler(v);

                //mTitleTextView.setText();
            }
        });

    }

    public void callWebserviceButtonHandler(View view){
        PingWebServiceTask task = new PingWebServiceTask();
//        try {
//            String url = NetworkUtil.validInput("http://www.omdbapi.com");
//            task.execute(url); // This is a security risk.  Don't let your user enter the URL in a real app.
//        } catch (NetworkUtil.MyException e) {
//            Toast.makeText(getApplication(),e.toString(), Toast.LENGTH_SHORT).show();
//
//        }
//        try {
//            String url = NetworkUtil.validInput("https://www.omdbapi.com/?apikey=fda7f7f9&t=Fargo");
//            URL urlResp = new URL("https://www.omdbapi.com/?apikey=fda7f7f9&t=Fargo" );
//            task.execute(url);
////            String resp = NetworkUtil.httpResponse(urlResp);
////            mTitleTextView.setText(resp);
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (NetworkUtil.MyException e) {
//            Toast.makeText(getApplication(),e.toString(), Toast.LENGTH_SHORT).show();
////
//        }

        task.execute();


    }

    private class PingWebServiceTask extends AsyncTask<String, Integer, JSONObject> {

        @Override
        protected void onProgressUpdate(Integer... values) {
            Log.i(TAG, "Making progress...");
        }

        @Override
        protected JSONObject doInBackground(String... params) {

            JSONObject jObject = new JSONObject();
            try {

                Uri.Builder builder = new Uri.Builder();
                builder.scheme("https")
                        .authority("www.omdbapi.com")
                        .appendQueryParameter("apikey", "fda7f7f9")
                        .appendQueryParameter("t", "Fargo");
                URL url = new URL(builder.build().toString());

                // Get String response from the url address
                String resp = NetworkUtil.httpResponse(url);
                //Log.i("resp",resp);

//                JSONArray jArray = new JSONArray(resp);    // Use this if your web service returns an array of objects.  Arrays are in [ ] brackets.

                // Transform String into JSONObject
                jObject = new JSONObject(resp);

                //Log.i("jTitle",jObject.getString("title"));
                //Log.i("jBody",jObject.getString("body"));
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
            TextView result_view = (TextView)findViewById(R.id.result_textView);
            try {
                result_view.setText(jObject.getString("Title"));
//                mTitleTextView.setText(jObject.getString("fuck"));
            } catch (JSONException e) {
                result_view.setText("Something went wrong!");
            }

        }


    }
}