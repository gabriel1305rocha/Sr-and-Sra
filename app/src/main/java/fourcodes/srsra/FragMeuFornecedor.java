package fourcodes.srsra;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragMeuFornecedor extends Fragment {

    View Fview;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Fview = inflater.inflate(R.layout.fragment_meu_fornecedor, container, false);

        return Fview;
    }
}