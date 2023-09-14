package fourcodes.srsra;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.login.LoginManager;

public class Configura extends Fragment {

    View Fview;
    Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Fview = inflater.inflate(R.layout.content_configura, container, false);
        context = Fview.getContext();

        TextView lblSair = (TextView) Fview.findViewById(R.id.lblSair);
        lblSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginManager.getInstance().logOut();
                context.startActivity(new Intent(context, Inicio.class));
                getActivity().finish();
            }
        });

        return Fview;
    }
}