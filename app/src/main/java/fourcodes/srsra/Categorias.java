package fourcodes.srsra;

import android.content.Context;

import java.util.ArrayList;

/**
 * Created by Felipe on 01/04/2017.
 */

public class Categorias {
    static ArrayList<CategoriaDataModel> dataModels;
    private static CustomCategoriaAdapter adapter;

    static public CustomCategoriaAdapter Categoria(Context context){

        dataModels= new ArrayList<>();
        dataModels.add(new CategoriaDataModel("Eletroeletrônicos", R.drawable.ic_cancel_red));
        dataModels.add(new CategoriaDataModel("Móveis", R.drawable.ic_edit));
        dataModels.add(new CategoriaDataModel("Cama, Mesa & Banho", R.drawable.ic_edit));

        adapter = new CustomCategoriaAdapter(dataModels, context);

        return adapter;
    }
}
