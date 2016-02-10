package edu.ucsb.cs.cs190i.brandonwicka.demosuite;


import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;


/**
 * A simple {@link Fragment} subclass.
 */
public class TextToSpeechFragment extends Fragment implements View.OnClickListener, TextToSpeech.OnInitListener {


    TextToSpeech engine;
    EditText editText;

    public TextToSpeechFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_text_to_speech, container, false);
        Button speakButton = (Button) view.findViewById(R.id.speak_button);
        speakButton.setOnClickListener(this);
        editText = (EditText) view.findViewById(R.id.edit_text);
        editText.getBackground().setColorFilter(Color.parseColor("#ff69b4"),PorterDuff.Mode.SRC_IN);
        engine = new TextToSpeech(getActivity().getApplicationContext(), this);

        return view;
    }



    @Override
    public void onClick(View v) {
        speech();
    }

    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS) {
            engine.setLanguage(Locale.US);
        }
    }


    public void speech() {
        engine.setPitch((float) 1.0);
        engine.setSpeechRate((float) 1.0);
        engine.speak(editText.getText().toString(), TextToSpeech.QUEUE_FLUSH, null, null);

    }
}
