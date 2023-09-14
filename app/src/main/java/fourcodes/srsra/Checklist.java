package fourcodes.srsra;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import static fourcodes.srsra.ListTarefas.ClickListTarefa;

public class Checklist extends Fragment {

    View Fview;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Fview = inflater.inflate(R.layout.content_checklist, container, false);

        ListView lstChek = (ListView) Fview.findViewById(R.id.lstChek);
        ArrayList<String> Menus = preencherdados();
        ArrayAdapter<String> ArrayAdapter = new ArrayAdapter<String>(Fview.getContext(), android.R.layout.simple_list_item_1, Menus);
        lstChek.setAdapter(ArrayAdapter);
        lstChek.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ClickListTarefa(position, Fview.getContext());
                getActivity().finish();
            }
        });
        return Fview;
    }
    private ArrayList<String> preencherdados() {
        ArrayList<String> dados = new ArrayList<String>();
        dados.add(getString(R.string.um_ano_antes));
        dados.add(getString(R.string.dez_meses_antes));
        dados.add(getString(R.string.oito_meses_antes));
        dados.add(getString(R.string.seis_meses_antes));
        dados.add(getString(R.string.tres_meses_antes));
        dados.add(getString(R.string.dois_meses_antes));
        dados.add(getString(R.string.um_mes_antes));
        dados.add(getString(R.string.quinze_dias_antes));
        dados.add(getString(R.string.uma_semana_antes));
        dados.add(getString(R.string.dois_dias_antes));
        dados.add(getString(R.string.um_dia_antes));
        dados.add(getString(R.string.o_grande_dia));
        dados.add(getString(R.string.na_volta));
        return dados;
    }
}