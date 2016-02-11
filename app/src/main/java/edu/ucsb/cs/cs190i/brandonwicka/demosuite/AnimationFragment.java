package edu.ucsb.cs.cs190i.brandonwicka.demosuite;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class AnimationFragment extends Fragment {


    public AnimationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_animation, container, false);

        BallView ballView = (BallView) view.findViewById(R.id.ball_view);

        DrawingThread thread = new DrawingThread(ballView, 50);
        thread.start();

        return view;
    }



}
