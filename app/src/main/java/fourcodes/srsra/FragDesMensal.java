package fourcodes.srsra;


import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import static fourcodes.srsra.FragDesItem.ItemsdataModels;

public class FragDesMensal extends Fragment {

    ArrayList<ItemDataModel> dataModels = ItemsdataModels;
    private static CustomListItemsAdapter adapter;
    int[] Meses = {R.string.janeiro,R.string.fervereiro,R.string.marco, R.string.abril,
            R.string.maio,R.string.junho, R.string.julho,R.string.agosto,
            R.string.setembro, R.string.outubro,R.string.novembro,R.string.dezembro};
    private int m=3;
    View Fview;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Fview = inflater.inflate(R.layout.fragment_des_mensal, container, false);

        AtualizaListaItem();
        ImageButton btnVoltar = (ImageButton) Fview.findViewById(R.id.btnVoltar);
        ImageButton btnAvanca = (ImageButton) Fview.findViewById(R.id.btnAvancar);
        final TextView txtMes = (TextView) Fview.findViewById(R.id.desMes);
        final TextView txtAno = (TextView) Fview.findViewById(R.id.desAno);

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (m >0){
                    m--;
                }else{
                    m=11;
                    txtAno.setText(""+(Integer.parseInt(txtAno.getText().toString())-1));
                }
                txtMes.setText(getString(Meses[m]));
            }
        });
        btnAvanca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (m <11){
                    m++;
                }else{
                    m=0;
                    txtAno.setText(""+(Integer.parseInt(txtAno.getText().toString())+1));
                }
                txtMes.setText(getString(Meses[m]));
            }
        });
        btnVoltar.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                SelecionaMesAno();
                return false;
            }
        });
        btnAvanca.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                SelecionaMesAno();
                return false;
            }
        });


        return Fview;
    }

    private void SelecionaMesAno(){

    }
    private void AtualizaListaItem(){
        ListView listView = (ListView) Fview.findViewById(R.id.list_despMes);

        //***** ItemDataModel(String name, String desc, String preco, String categoria, String paga, String total) ******//
        //dataModels.add(new ItemDataModel("Vestido", "Branco com véu", "1000,00","Roupa","1","12"));
        //dataModels.add(new ItemDataModel("Bolo", "Bolo festa", "250,00","Comida","3","5"));

        adapter= new CustomListItemsAdapter(dataModels,Fview.getContext());

        listView.setAdapter(adapter);
    }
}
