package edu.neu.madcourse.numad21sp_bayleycarter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity2 extends AppCompatActivity {

    Button aButton;
    Button bButton;
    Button cButton;
    Button dButton;
    Button eButton;
    Button fButton;
    TextView btnPressed;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent myIntent = getIntent();

        aButton = (Button) findViewById(R.id.A_button);
        bButton = (Button) findViewById(R.id.B_button);
        cButton = (Button) findViewById(R.id.C_button);
        dButton = (Button) findViewById(R.id.D_button);
        eButton = (Button) findViewById(R.id.E_button);
        fButton = (Button) findViewById(R.id.F_button);
        btnPressed = (TextView) findViewById(R.id.pressedButton);

    }


    public void onClick(View view) {

        switch(view.getId()) {
            case R.id.A_button:
                btnPressed.setText("Pressed: A");
                break;
            case R.id.B_button:
                btnPressed.setText("Pressed: B");
                break;
            case R.id.C_button:
                btnPressed.setText("Pressed: C");
                break;
            case R.id.D_button:
                btnPressed.setText("Pressed: D");
                break;
            case R.id.E_button:
                btnPressed.setText("Pressed: E");
                break;
            case R.id.F_button:
                btnPressed.setText("Pressed: F");
                break;

        }
    }





}