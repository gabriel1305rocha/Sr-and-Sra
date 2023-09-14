package fourcodes.srsra;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Sobre extends Fragment {

    View Fview;
    Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Fview = inflater.inflate(R.layout.content_sobre, container, false);
        context = Fview.getContext();
        Button termo = (Button) Fview.findViewById(R.id.termo);
        Button manual = (Button) Fview.findViewById(R.id.manualUser);
        termo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(context, Termo_Uso.class));
                getActivity().finish();
            }
        });
        manual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(context, Manual_Usuario.class));
                getActivity().finish();
            }
        });

        return Fview;
    }
}