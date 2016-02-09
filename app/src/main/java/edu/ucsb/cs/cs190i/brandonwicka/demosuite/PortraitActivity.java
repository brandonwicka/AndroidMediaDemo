package edu.ucsb.cs.cs190i.brandonwicka.demosuite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.FrameLayout;

public class PortraitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portrait);


        String s = getIntent().getStringExtra("Display");

      //  bundle.putString("Display", s);
       // AudioFragment f = new AudioFragment();
        //f.setArguments(bundle);
        //getSupportFragmentManager().beginTransaction().replace(R.id.portrait_layout, f).commit();

        if(s.equals("Speechtotext")) {
            Bundle bundle = new Bundle();
            bundle.putString("Display", s);
            SpeechToTextFragment fragment = new SpeechToTextFragment();
            fragment.setArguments(bundle);
            getSupportFragmentManager().beginTransaction().replace(R.id.portrait_layout, fragment).commit();
        }

        else if(s.equals("Texttospeech")) {
            Bundle bundle = new Bundle();
            bundle.putString("Display", s);
            TextToSpeechFragment fragment = new TextToSpeechFragment();
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

}
