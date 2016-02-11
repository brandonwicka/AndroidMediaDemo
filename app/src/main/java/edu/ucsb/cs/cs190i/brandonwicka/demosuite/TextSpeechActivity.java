package edu.ucsb.cs.cs190i.brandonwicka.demosuite;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class TextSpeechActivity extends AppCompatActivity {


    TextToSpeechFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_speech);

        if(savedInstanceState != null) {
            fragment = (TextToSpeechFragment)getSupportFragmentManager().getFragment(savedInstanceState,"mcontent");

        }
        else {
            if (fragment == null)
            fragment = new TextToSpeechFragment();
        }

        getSupportFragmentManager().beginTransaction().replace(R.id.textspeech_frame, fragment).commit();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        getSupportFragmentManager().putFragment(outState, "mcontent", fragment);
    }


    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }


}
