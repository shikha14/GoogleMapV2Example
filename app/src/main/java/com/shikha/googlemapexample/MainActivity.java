package com.shikha.googlemapexample;

import android.content.Intent;
import android.graphics.Camera;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;



public class MainActivity extends FragmentActivity {


    private GoogleMap googleMap;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        try {
            // Loading map
            initilizeMap();
            if(googleMap!=null)
            {

                googleMap.setMyLocationEnabled(true);
                setMapToSpecificArea();



                //add all marker
                addMarker(12.978028,77.599647,"Figurine Fitness","No. 10, MG Road, Chinnaswamy Stadium, Shanthala Nagar, Bengaluru 560001");
                addMarker(12.966851,77.599434,"ZELA Luxury Health Club","Ground Floor,The Residency,133/1 Residency Road, Near The Chancery Pavilion Hotel, Bangalore");
                addMarker(12.963868,77.592422,"Eternal Fitness","# 112, 566, M S Plaza,3rd Floor 13 A Cross, Opposite Telephone Exchange, Near S R Nagar Police Station, 4th Main Road, Sampangi Rama Nagar, Bengaluru");
                addMarker(12.971104,77.592831,"Bapuji Surgicals","Ambedkar Veedhi, Sampangi Rama Nagar, Bengaluru");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private void setMapToSpecificArea() {
        // define point to center on
        LatLng origin = new LatLng(12.978028,77.599647);
        CameraUpdate panToOrigin = CameraUpdateFactory.newLatLng(origin);
        googleMap.moveCamera(panToOrigin);
        // set zoom level with animation
        googleMap.animateCamera(CameraUpdateFactory.zoomTo(14), 400, null);
    }

    /**
     * function to load map. If map is not created it will create it for you
     * */
    private void initilizeMap() {
        if (googleMap == null) {
            googleMap = ((MapFragment) getFragmentManager().findFragmentById(
                    R.id.map)).getMap();



            // check if map is created successfully or not
            if (googleMap == null) {
                Toast.makeText(getApplicationContext(),
                        "Sorry! unable to create maps", Toast.LENGTH_SHORT)
                        .show();
            }
        }
    }

    public void addMarker(double latitude ,
            double longitude,String title,String snippet)
    {
        // create marker
        MarkerOptions marker = new MarkerOptions().position(new LatLng(latitude, longitude)).title(title).snippet(snippet);
        // adding marker
        googleMap.addMarker(marker);
    }

    @Override
    protected void onResume() {
        super.onResume();
        initilizeMap();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
