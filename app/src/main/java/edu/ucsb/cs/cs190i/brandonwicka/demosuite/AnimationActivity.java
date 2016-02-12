package edu.ucsb.cs.cs190i.brandonwicka.demosuite;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class AnimationActivity extends AppCompatActivity {

    protected final String FRAGMENT_KEY = "my_key";
    AnimationFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        if(savedInstanceState != null) {
            fragment = (AnimationFragment)getSupportFragmentManager().getFragment(savedInstanceState,FRAGMENT_KEY);

        }
        else {
            if (fragment == null)
                fragment = new AnimationFragment();
        }

        getSupportFragmentManager().beginTransaction().replace(R.id.animation_frame, fragment).commit();
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        getSupportFragmentManager().putFragment(outState, FRAGMENT_KEY, fragment);
    }



    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }




}
