package fourcodes.srsra;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapterCategoria extends ArrayAdapter<DataModelCategoria> {

    Context mContext;
    private ArrayList<DataModelCategoria> dataSet;
    private int lastPosition = -1;

    public CustomAdapterCategoria(ArrayList<DataModelCategoria> data, Context context) {
        super(context, R.layout.list_categoria_layout, data);
        this.dataSet = data;
        this.mContext = context;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final DataModelCategoria dataModel = getItem(position);
        final CustomAdapterCategoria.ViewHolder viewHolder;

        final View result;

        if (convertView == null) {


            viewHolder = new CustomAdapterCategoria.ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.list_categoria_layout, parent, false);
            viewHolder.txtCategoria = (TextView) convertView.findViewById(R.id.nome);
            viewHolder.imgCategoria = (ImageView) convertView.findViewById(R.id.image);

            result = convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (CustomAdapterCategoria.ViewHolder) convertView.getTag();
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