package fourcodes.srsra;


import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;



public class FragDesItem extends Fragment {

    ArrayList<ItemDataModel> dataModels;
    ListView listView;
    private static CustomListItemsAdapter adapter;
    static Button filtro;
    View Fview;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Fview=inflater.inflate(R.layout.fragment_des_item, container, false);

        // Botão Filtro
        filtro = (Button) Fview.findViewById(R.id.btnPesquisa);
        filtro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setVisibility(View.GONE);
            }
        });
        filtro.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                return false;
            }
        });

        // List View
        AtualizaListaItem();

        // Spinner
        Spinner spinfiltro = (Spinner) Fview.findViewById(R.id.spinOrgani);
        ArrayAdapter<CharSequence> adapterFiltro = ArrayAdapter.createFromResource(Fview.getContext(),
                R.array.filtro, android.R.layout.simple_spinner_item);
        adapterFiltro.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinfiltro.setAdapter(adapterFiltro);


        return Fview;
    }

    public void AtualizaListaItem(){
        ListView listView = (ListView) Fview.findViewById(R.id.lista_items);
        dataModels= new ArrayList<>();

        //***** ItemDataModel(String name, String desc, String preco, String categoria, String paga, String total) ******//
        dataModels.add(new ItemDataModel("Vestido", "Branco com véu", "1000,00","Roupa","1","12"));
        dataModels.add(new ItemDataModel("Bolo", "Bolo festa", "250,00","Comida","3","5"));

        adapter= new CustomListItemsAdapter(dataModels,Fview.getContext());

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                ItemDataModel dataModel= dataModels.get(position);

                Snackbar.make(view, dataModel.getName()+" - "+dataModel.getDesc()+"\n R$ "+dataModel.getPreco(), Snackbar.LENGTH_LONG)
                        .setAction("No action", null).show();
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id){

                ItemDataModel dataModel= dataModels.get(position);
                new EditarItem(position, Fview.getContext(),
                        dataModel.getName(), dataModel.getDesc(), dataModel.getPreco(),
                        dataModel.getPaga(),dataModel.getTotal());
                return false;
            }
        });
    }
    static protected void Pesquisa(String conteudo){
        filtro.setText(conteudo);
        filtro.setVisibility(View.VISIBLE);
    }
}
