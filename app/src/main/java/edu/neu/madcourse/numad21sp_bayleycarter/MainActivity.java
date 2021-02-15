package edu.neu.madcourse.numad21sp_bayleycarter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.TextView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    TextView txt;
    Button btn;
    Button clickHere;
    Button linkList;

//    text button
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = (TextView) findViewById(R.id.nameemail);
        btn = (Button) findViewById(R.id.aboutbutton);
        clickHere = (Button) findViewById(R.id.clickHereButton);
        linkList = (Button) findViewById(R.id.linkButton);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt.setText("Bayley Carter\ncarter.ba@northeastern.edu");
            }

        });
        clickHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSixButtons();
            }
        });
        linkList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getLinkList();
            }
        });

    }

    private void getSixButtons() {
        Intent intent2 = new Intent(MainActivity.this, MainActivity2.class);
        MainActivity.this.startActivity(intent2);


    }

    private void getLinkList() {
        Intent intent3 = new Intent(MainActivity.this, MainActivity3.class);
        MainActivity.this.startActivity(intent3);


    }
}