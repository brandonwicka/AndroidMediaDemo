package edu.ucsb.cs.cs190i.brandonwicka.demosuite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SpeechTextActivity extends AppCompatActivity {

    SpeechToTextFragment fragment;
    private final String FRAG_KEY = "unique_key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speech_text);

        if(savedInstanceState != null) {
            fragment = (SpeechToTextFragment)getSupportFragmentManager().getFragment(savedInstanceState,FRAG_KEY);

        }
        else {
            if (fragment == null)
                fragment = new SpeechToTextFragment();
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.speechtext_frame, fragment).commit();
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        getSupportFragmentManager().putFragment(outState, FRAG_KEY, fragment);
    }


    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

}
