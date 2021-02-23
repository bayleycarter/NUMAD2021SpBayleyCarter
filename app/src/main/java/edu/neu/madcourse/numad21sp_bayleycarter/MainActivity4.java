package edu.neu.madcourse.numad21sp_bayleycarter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;


public class MainActivity4 extends AppCompatActivity {

    private TextView locationText;
    LocationManager locationManager;
    String latitude, longitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        locationText = (TextView) findViewById(R.id.locationText);
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);


        getLocation();
    }


    private void getLocation() {
        if (ActivityCompat.checkSelfPermission(
                this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        } else {
            Location loc = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            if (loc != null) {
                double numLatitude = loc.getLatitude();
                double numLongitude = loc.getLongitude();
                latitude = String.valueOf(numLatitude);
                longitude = String.valueOf(numLongitude);
                locationText.setText("Latitude: " + latitude + "\n" + "Longitude: " + longitude);

            }

        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1) {
            for (int i = 0; i < permissions.length; i++) {
                int grant = grantResults[i];
                String perm = permissions[i];
                if (perm.equals(Manifest.permission.ACCESS_FINE_LOCATION)) {
                    if (grant == PackageManager.PERMISSION_GRANTED) {
                        getLocation();
                    } else {
                        locationText.setText("Sorry! Cannot show location without permission.");
                    }
                }
            }
        }
    }

}