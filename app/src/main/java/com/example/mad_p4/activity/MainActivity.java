package com.example.mad_p4.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.mad_p4.R;
import com.example.mad_p4.fragment.RandomDadJokeFragment;
import com.example.mad_p4.fragment.SearchDadJokeFragment;
import com.example.mad_p4.requester.RandomDadJokeRequester;

public class MainActivity extends AppCompatActivity {

    RandomDadJokeRequester joker;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
        RandomDadJokeFragment dist = (RandomDadJokeFragment)fm.findFragmentById(R.id.distanceFrag);
        SearchDadJokeFragment temp = (SearchDadJokeFragment)fm.findFragmentById(R.id.tempFrag);
        ft.show(dist);
        ft.hide(temp);
        ft.commit();
    }
    public void displayTempFragment() {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        FragmentManager fm = getSupportFragmentManager();
        RandomDadJokeFragment dist = (RandomDadJokeFragment)fm.findFragmentById(R.id.distanceFrag);
        SearchDadJokeFragment temp = (SearchDadJokeFragment)fm.findFragmentById(R.id.tempFrag);
        ft.show(temp);
        ft.hide(dist);
        ft.commit();
    }
}