package edu.ucsb.cs.cs190i.brandonwicka.demosuite;


import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;


/**
 * A simple {@link Fragment} subclass.
 */
public class VideoFragment extends Fragment {


    public VideoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_video, container, false);
        VideoView videoView = (VideoView) view.findViewById(R.id.video_view);
        videoView.setMediaController(new MediaController(getContext()));
        Uri video = Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.bigbuck);
        videoView.setVideoURI(video);
        videoView.start();
        return view;
    }

}
