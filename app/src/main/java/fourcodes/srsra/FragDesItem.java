package fourcodes.srsra;


import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;



public class FragDesItem extends Fragment {

    static ArrayList<ItemDataModel> ItemsdataModels = new ArrayList<>();
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

        adapter= new CustomListItemsAdapter(ItemsdataModels,Fview.getContext());

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                ItemDataModel dataModel= ItemsdataModels.get(position);

                Snackbar snackbar;
                snackbar = Snackbar.make(view, getString(R.string.data_inicial)+": "+dataModel.getDataInicial()+"        -"+dataModel.getName()+"\n"
                                +getString(R.string.data_termino)+": "+dataModel.getDataTermino()
                        ,Snackbar.LENGTH_LONG).setAction("No action", null);
                snackbar.setActionTextColor(getResources().getColor(R.color.white));
                snackbar.show();
            }
        });
        listView.setOnCreateContextMenuListener(new View.OnCreateContextMenuListener() {
            @Override
            public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
                contextMenu.add(Menu.NONE,1,Menu.NONE,getString(R.string.editar));
                contextMenu.add(Menu.NONE,2,Menu.NONE,getString(R.string.deletar));
            }
        });
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo menuInfo =
                (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int position = menuInfo.position;
        switch (item.getItemId()) {
            case 1:
                Alterar(position);
                return true;
            case 2:
                Deletar(position);
                return true;
        }
        return super.onContextItemSelected(item);
    }
    protected void Alterar(int position){
        ItemDataModel dataModel= ItemsdataModels.get(position);
        new EditarItem(position, Fview.getContext(),
                dataModel.getName(), dataModel.getDesc(), dataModel.getPreco(),
                dataModel.getPaga(),dataModel.getTotal());
    }
    protected void Deletar(int position){
        ItemsdataModels.remove(position);
        adapter.notifyDataSetChanged();
    }

    static protected void Pesquisa(String conteudo){
        filtro.setText(conteudo);
        filtro.setVisibility(View.VISIBLE);
    }
}
