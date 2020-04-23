/**
 * AUTHOR: MITCHELL MYERS, IAN SIMON
 * DATE: 4/23/2020
 */

package com.example.mad_p4.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.mad_p4.R;

public class MainActivity extends AppCompatActivity {
    Fragment randomJokeFragment;
    Fragment searchJokeFragment;
    Fragment currentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        randomJokeFragment = getSupportFragmentManager().findFragmentById(R.id.fragment_random_joke);
        searchJokeFragment = getSupportFragmentManager().findFragmentById(R.id.fragment_search_joke);



        if (savedInstanceState == null) {
            currentFragment = searchJokeFragment;
            display(randomJokeFragment);
        }
        else {
            boolean flag = getPreferences(MODE_PRIVATE).getBoolean("random", true);
            if (flag) {
                currentFragment = randomJokeFragment;
            }
            else {
                currentFragment = searchJokeFragment;
            }
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

        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        if (currentFragment == randomJokeFragment) {
            preferences.edit()
                    .putBoolean("random", true)
                    .apply();
        }
        else {
            preferences.edit()
                    .putBoolean("random", false)
                    .apply();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.search_settings:
                display(searchJokeFragment);
                return true;

            case R.id.random_joke_settings:
                display(randomJokeFragment);
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }

    }

    public void display(Fragment fragment) {

        // hide the current fragment and display the new one
        getSupportFragmentManager()
                .beginTransaction()
                .hide(currentFragment)
                .show(fragment)
                .commit(); // save these changes

        currentFragment = fragment; // record the new fragment as the current fragment
    }
}
