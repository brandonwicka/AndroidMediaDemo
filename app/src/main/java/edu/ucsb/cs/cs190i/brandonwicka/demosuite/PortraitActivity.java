package edu.ucsb.cs.cs190i.brandonwicka.demosuite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.FrameLayout;

public class PortraitActivity extends AppCompatActivity {

    TextToSpeechFragment fragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portrait);

        String s = getIntent().getStringExtra("Display");

        if(s.equals("Speechtotext")) {
            Bundle bundle = new Bundle();
            bundle.putString("Display", s);
            SpeechToTextFragment fragment = new SpeechToTextFragment();
            fragment.setArguments(bundle);
            getSupportFragmentManager().beginTransaction().replace(R.id.portrait_layout, fragment).commit();
        }

        else if(s.equals("Texttospeech")) {
            if(savedInstanceState != null) {
                fragment = (TextToSpeechFragment)getSupportFragmentManager().getFragment(savedInstanceState, "mContent");
            }
            Bundle bundle = new Bundle();
            bundle.putString("Display", s);
            fragment = new TextToSpeechFragment();
            fragment.setArguments(bundle);
            getSupportFragmentManager().beginTransaction().replace(R.id.portrait_layout, fragment).commit();
        }


        else if(s.equals("Audio")) {
            Bundle bundle = new Bundle();
            bundle.putString("Display", s);
            AudioFragment fragment = new AudioFragment();
            fragment.setArguments(bundle);
            getSupportFragmentManager().beginTransaction().replace(R.id.portrait_layout, fragment).commit();
        }

        else if (s.equals("Video")) {
            Bundle bundle = new Bundle();
            bundle.putString("Display", s);
            VideoFragment fragment = new VideoFragment();
            fragment.setArguments(bundle);
            getSupportFragmentManager().beginTransaction().replace(R.id.portrait_layout, fragment).commit();
        }

        else if(s.equals("Animation")) {
            Bundle bundle = new Bundle();
            bundle.putString("Display", s);
            AnimationFragment fragment = new AnimationFragment();
            fragment.setArguments(bundle);
            getSupportFragmentManager().beginTransaction().replace(R.id.portrait_layout, fragment).commit();
        }






    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        //Save the fragment's instance
        getSupportFragmentManager().putFragment(outState, "mContent", fragment);
    }

}
