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
                    Bundle bundle = new Bundle();
                    bundle.putString("Display", "Speechtotext");
                    SpeechToTextFragment fragment = new SpeechToTextFragment();
                    fragment.setArguments(bundle);
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, fragment).commit();

                }

                else {
                    Intent intent = new Intent(MainActivity.this, PortraitActivity.class);
                    intent.putExtra("Display", "Speechtotext");
                    startActivity(intent);
                }

            }
        });

        textToSpeech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(landscape) {
                    Bundle bundle = new Bundle();
                    bundle.putString("Display", "Texttospeech");
                    TextToSpeechFragment fragment = new TextToSpeechFragment();
                    fragment.setArguments(bundle);
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, fragment).commit();

                }

                else {
                    Intent intent = new Intent(MainActivity.this, PortraitActivity.class);
                    intent.putExtra("Display", "Texttospeech");
                    startActivity(intent);
                }

            }
        });

        audioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (landscape) {
                    Bundle bundle = new Bundle();
                    bundle.putString("Display", "Audio");
                    AudioFragment fragment = new AudioFragment();
                    fragment.setArguments(bundle);
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, fragment).commit();

                }
                else {
                    Intent intent = new Intent(MainActivity.this, PortraitActivity.class);
                    intent.putExtra("Display", "Audio");
                    startActivity(intent);
                }

            }
        });

        videoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (landscape) {
                    Bundle bundle = new Bundle();
                    bundle.putString("Display", "Video");
                    VideoFragment fragment = new VideoFragment();
                    fragment.setArguments(bundle);
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, fragment).commit();

                }
                else {
                    Intent intent = new Intent(MainActivity.this, PortraitActivity.class);
                    intent.putExtra("Display", "Video");
                    startActivity(intent);
                }

            }
        });

        animationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(landscape) {
                    Bundle bundle = new Bundle();
                    bundle.putString("Display", "Animation");
                    AnimationFragment fragment = new AnimationFragment();
                    fragment.setArguments(bundle);
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, fragment).commit();

                }

                else {
                    Intent intent = new Intent(MainActivity.this, PortraitActivity.class);
                    intent.putExtra("Display", "Animation");
                    startActivity(intent);
                }

            }
        });

    }
}
