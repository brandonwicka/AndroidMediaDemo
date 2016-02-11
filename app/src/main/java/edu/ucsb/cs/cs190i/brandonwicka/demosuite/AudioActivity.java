package edu.ucsb.cs.cs190i.brandonwicka.demosuite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class AudioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio);

        AudioFragment fragment = new AudioFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.audio_frame, fragment).commit();
    }
}
