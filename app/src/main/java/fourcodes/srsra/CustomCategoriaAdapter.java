package fourcodes.srsra;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Felipe on 01/04/2017.
 */

public class CustomCategoriaAdapter extends ArrayAdapter<CategoriaDataModel> {

    Context mContext;
    private ArrayList<CategoriaDataModel> dataSet;
    private int lastPosition = -1;

    public CustomCategoriaAdapter(ArrayList<CategoriaDataModel> data, Context context) {
        super(context, R.layout.list_categoria_layout, data);
        this.dataSet = data;
        this.mContext = context;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final CategoriaDataModel dataModel = getItem(position);
        final CustomCategoriaAdapter.ViewHolder viewHolder;

        final View result;

        if (convertView == null) {


            viewHolder = new CustomCategoriaAdapter.ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.list_categoria_layout, parent, false);
            viewHolder.txtCategoria = (TextView) convertView.findViewById(R.id.nome);
            viewHolder.imgCategoria = (ImageView) convertView.findViewById(R.id.image);

            result = convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (CustomCategoriaAdapter.ViewHolder) convertView.getTag();
            result = convertView;
        }

        lastPosition = position;

        viewHolder.txtCategoria.setText(dataModel.getCategoria());
        viewHolder.imgCategoria.setImageResource(dataModel.getImagen());

        // Return the completed view to render on screen
        return convertView;
    }

    // View lookup cache
    private static class ViewHolder {
        TextView txtCategoria;
        ImageView imgCategoria;
    }


}