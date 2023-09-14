package fourcodes.srsra;

import android.content.Context;

import java.util.ArrayList;



public class Categorias {
    static ArrayList<DataModelCategoria> dataModels;
    private static CustomAdapterCategoria adapter;

    static public CustomAdapterCategoria Categoria(Context context){

        dataModels= new ArrayList<>();
        dataModels.add(new DataModelCategoria("Eletroeletrônicos", R.drawable.ic_cancel_red));
        dataModels.add(new DataModelCategoria("Móveis", R.drawable.ic_edit));
        dataModels.add(new DataModelCategoria("Cama, Mesa & Banho", R.drawable.ic_edit));

        adapter = new CustomAdapterCategoria(dataModels, context);

        return adapter;
    }
}
