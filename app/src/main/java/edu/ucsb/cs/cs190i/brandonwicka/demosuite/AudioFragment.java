package edu.ucsb.cs.cs190i.brandonwicka.demosuite;


import android.content.Context;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class AudioFragment extends Fragment implements View.OnClickListener {

    Button button;

    public AudioFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_audio, container, false);
        button = (Button) view.findViewById(R.id.play_audio_button);
        button.setOnClickListener(this);
        return view;
    }


    @Override
    public void onClick(View v) {
        MediaPlayer mp = MediaPlayer.create(getContext(), R.raw.fanfare);
        mp.start();

    }


}
