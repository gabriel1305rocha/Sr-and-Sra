package fourcodes.srsra;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragConvites.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragConvites#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragConvites extends Fragment {
    View Fview;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Fview=inflater.inflate(R.layout.fragment_frag_convites, container, false);
        return Fview;
    }
}