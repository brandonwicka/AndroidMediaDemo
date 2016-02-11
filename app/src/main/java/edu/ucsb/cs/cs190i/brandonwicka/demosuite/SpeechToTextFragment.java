package edu.ucsb.cs.cs190i.brandonwicka.demosuite;



import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;


/**
 * A simple {@link Fragment} subclass.
 */
public class SpeechToTextFragment extends Fragment implements View.OnClickListener {


    private final int REQ_CODE_SPEECH_INPUT = 1001;
    private final String TEXT_KEY = "keyvalue";
    ArrayList<String> a = new ArrayList<>();
    ImageButton micButton;
    TextView textSpeech;


    public SpeechToTextFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_speech_to_text, container, false);
        textSpeech = (TextView) view.findViewById(R.id.text_speak);

        if (savedInstanceState != null) {
            String s = savedInstanceState.getString("TEXT_KEY");
            textSpeech.setText(s);
            micButton = (ImageButton) view.findViewById(R.id.img_button);
            micButton.setOnClickListener(this);
        }
        else {
            micButton = (ImageButton) view.findViewById(R.id.img_button);
            micButton.setOnClickListener(this);
        }

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case REQ_CODE_SPEECH_INPUT: {
                if (resultCode == getActivity().RESULT_OK && null != data) {

                    ArrayList<String> result = data
                            .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    textSpeech.setText(result.get(0));
                    a.add(textSpeech.getText().toString());
                }
                break;
            }

        }
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());

        try {
            startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(getActivity().getApplicationContext(),getString(R.string.error_text), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (a.isEmpty()) {
            textSpeech.setText("");
            //outState.putString(TEXT_KEY, textSpeech.getText().toString());
        } else {
            textSpeech.setText(a.get(0));
            outState.putString(TEXT_KEY, textSpeech.getText().toString());
            Toast.makeText(getContext(), "This is saving" + textSpeech.getText().toString(), Toast.LENGTH_SHORT).show();
        }

    }





}
