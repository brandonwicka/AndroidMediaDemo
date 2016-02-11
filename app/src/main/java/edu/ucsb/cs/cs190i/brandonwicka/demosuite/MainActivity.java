package edu.ucsb.cs.cs190i.brandonwicka.demosuite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    boolean landscape = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(findViewById(R.id.frame_layout) != null) {
            landscape = true;
        }

        Button speechToText = (Button) findViewById(R.id.speech_to_text_button);
        Button textToSpeech = (Button) findViewById(R.id.text_to_speech_button);
        Button audioButton = (Button) findViewById(R.id.audio_button);
        Button videoButton = (Button) findViewById(R.id.video_button);
        Button animationButton = (Button) findViewById(R.id.animation_button);

        speechToText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(landscape) {
                    SpeechToTextFragment fragment = new SpeechToTextFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, fragment).commit();
                }
                else {
                    Intent intent = new Intent(MainActivity.this, SpeechTextActivity.class);
                    startActivity(intent);
                }

            }
        });

        textToSpeech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(landscape) {
                    TextToSpeechFragment fragment = new TextToSpeechFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, fragment).commit();
                }
                else {
                    Intent intent = new Intent(MainActivity.this, TextSpeechActivity.class);
                    startActivity(intent);
                }

            }
        });

        audioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (landscape) {
                    AudioFragment fragment = new AudioFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, fragment).commit();
                }
                else {
                    Intent intent = new Intent(MainActivity.this, AudioActivity.class);
                    startActivity(intent);
                }

            }
        });

        videoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (landscape) {
                    VideoFragment fragment = new VideoFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, fragment).commit();
                }
                else {
                    Intent intent = new Intent(MainActivity.this, VideoActivity.class);
                    startActivity(intent);
                }

            }
        });

        animationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(landscape) {
                    AnimationFragment fragment = new AnimationFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, fragment).commit();
                }
                else {
                    Intent intent = new Intent(MainActivity.this, AnimationActivity.class);
                    startActivity(intent);
                }

            }
        });

    }
}
