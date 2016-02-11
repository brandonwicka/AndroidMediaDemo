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
import android.widget.Toast;

import java.util.Locale;


/**
 * A simple {@link Fragment} subclass.
 */
public class TextToSpeechFragment extends Fragment implements View.OnClickListener, TextToSpeech.OnInitListener {


    TextToSpeech engine;
    EditText editText;
    private final String TEXT_KEY = "keyvalue";

    public TextToSpeechFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_text_to_speech, container, false);
        editText = (EditText) view.findViewById(R.id.edit_text);
        editText.getBackground().setColorFilter(Color.parseColor("#ff69b4"), PorterDuff.Mode.SRC_IN);


        if (savedInstanceState != null) {
            String s = savedInstanceState.getString("TEXT_KEY");
            editText.setText(s);
            Button speakButton = (Button) view.findViewById(R.id.speak_button);
            speakButton.setOnClickListener(this);
            engine = new TextToSpeech(getActivity().getApplicationContext(), this);
        }
        else {
            Button speakButton = (Button) view.findViewById(R.id.speak_button);
            speakButton.setOnClickListener(this);
            engine = new TextToSpeech(getActivity().getApplicationContext(), this);
        }

        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(TEXT_KEY, editText.getText().toString());
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
