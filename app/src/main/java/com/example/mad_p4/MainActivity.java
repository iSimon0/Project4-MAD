package com.example.mad_p4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import org.json.JSONException;

public class MainActivity extends AppCompatActivity {

    DadJokeRequester reader;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        reader = new DadJokeRequester(this);
        reader.addOnRequestFinishedListener(new DadJokeListener());

        try {
            reader.requestRandomDadJoke();
        }
        catch (JSONException e) {
            e.printStackTrace();
        }

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
    @Override
    public void onSaveInstanceState(Bundle saveInstanceState){
        super.onSaveInstanceState(saveInstanceState);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.temp_settings:
                displayTempFragment();
                return true;
            case R.id.distance_settings:
                displayDistFragment();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public void displayDistFragment() {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        FragmentManager fm = getSupportFragmentManager();
        DistanceFragment dist = (DistanceFragment)fm.findFragmentById(R.id.distanceFrag);
        TempFragment temp = (TempFragment)fm.findFragmentById(R.id.tempFrag);
        ft.show(dist);
        ft.hide(temp);
        ft.commit();
    }
    public void displayTempFragment() {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        FragmentManager fm = getSupportFragmentManager();
        DistanceFragment dist = (DistanceFragment)fm.findFragmentById(R.id.distanceFrag);
        TempFragment temp = (TempFragment)fm.findFragmentById(R.id.tempFrag);
        ft.show(temp);
        ft.hide(dist);
        ft.commit();
    }
}
