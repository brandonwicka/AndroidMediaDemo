package edu.ucsb.cs.cs190i.brandonwicka.demosuite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SpeechTextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speech_text);

       // Bundle bundle = new Bundle();
       // bundle.putString("Display", s);
        SpeechToTextFragment fragment = new SpeechToTextFragment();
       // fragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.speechtext_frame, fragment).commit();
    }
}
