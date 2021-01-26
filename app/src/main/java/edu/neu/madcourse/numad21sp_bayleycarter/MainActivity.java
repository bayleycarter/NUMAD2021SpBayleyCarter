package edu.neu.madcourse.numad21sp_bayleycarter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.TextView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    TextView txt;
    Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = (TextView) findViewById(R.id.nameemail);
        btn = (Button) findViewById(R.id.aboutbutton);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt.setText("Bayley Carter\ncarter.ba@northeastern.edu");
            }

        });
    }
}