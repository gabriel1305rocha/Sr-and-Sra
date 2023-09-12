package fourcodes.srsra;


import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


public class FragDesItem extends Fragment {

    ArrayList<ItemDataModel> dataModels;
    ListView listView;
    private static CustomListItemsAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_des_item, container, false);
        ListView listView = (ListView) view.findViewById(R.id.lista_items);
        dataModels= new ArrayList<>();

        //***** ItemDataModel(String name, String desc, String preco, String categoria, String paga, String total) ******//
        dataModels.add(new ItemDataModel("Vestido", "Branco com véu", "1000,00","Roupa","1","12"));
        dataModels.add(new ItemDataModel("Bolo", "Bolo festa", "250,00","Comida","3","5"));
        /*dataModels.add(new ItemDataModel("Cupcake", "Android 1.5", "3","April 27, 2009"));
        dataModels.add(new ItemDataModel("Donut","Android 1.6","4","September 15, 2009"));
        dataModels.add(new ItemDataModel("Eclair", "Android 2.0", "5","October 26, 2009"));
        dataModels.add(new ItemDataModel("Froyo", "Android 2.2", "8","May 20, 2010"));
        dataModels.add(new ItemDataModel("Gingerbread", "Android 2.3", "9","December 6, 2010"));
        dataModels.add(new ItemDataModel("Honeycomb","Android 3.0","11","February 22, 2011"));
        dataModels.add(new ItemDataModel("Ice Cream Sandwich", "Android 4.0", "14","October 18, 2011"));
        dataModels.add(new ItemDataModel("Jelly Bean", "Android 4.2", "16","July 9, 2012"));
        dataModels.add(new ItemDataModel("Kitkat", "Android 4.4", "19","October 31, 2013"));
        dataModels.add(new ItemDataModel("Lollipop","Android 5.0","21","November 12, 2014"));
        dataModels.add(new ItemDataModel("Marshmallow", "Android 6.0", "23","October 5, 2015"));*/

        adapter= new CustomListItemsAdapter(dataModels,view.getContext());

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                ItemDataModel dataModel= dataModels.get(position);

                Snackbar.make(view, dataModel.getName()+" - "+dataModel.getDesc()+"\n R$ "+dataModel.getPreco(), Snackbar.LENGTH_LONG)
                        .setAction("No action", null).show();
            }
        });
        return view;
    }
}
