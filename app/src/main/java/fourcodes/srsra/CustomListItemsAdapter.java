package fourcodes.srsra;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomListItemsAdapter extends ArrayAdapter<ItemDataModel> implements View.OnClickListener {

    Context mContext;
    private ArrayList<ItemDataModel> dataSet;
    private int lastPosition = -1;


    public CustomListItemsAdapter(ArrayList<ItemDataModel> data, Context context) {
        super(context, R.layout.list_items, data);
        this.dataSet = data;
        this.mContext = context;

    }

    @Override
    public void onClick(View v) {

        int position = (Integer) v.getTag();
        Object object = getItem(position);
        ItemDataModel dataModel = (ItemDataModel) object;

        switch (v.getId()) {
            case R.id.item_box:
                /*Snackbar.make(v, "Release date " +dataModel.getFeature(), Snackbar.LENGTH_LONG)
                        .setAction("No action", null).show();*/
                break;
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        ItemDataModel dataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.list_items, parent, false);
            viewHolder.txtName = (TextView) convertView.findViewById(R.id.name);
            viewHolder.txtDesc = (TextView) convertView.findViewById(R.id.descricao);
            viewHolder.txtPreco = (TextView) convertView.findViewById(R.id.preco_num);
            viewHolder.txtParPaga = (TextView) convertView.findViewById(R.id.parcelPagas);
            viewHolder.txtParTotal = (TextView) convertView.findViewById(R.id.parcelTotal);
            viewHolder.compl = (CheckBox) convertView.findViewById(R.id.item_box);

            result = convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }

        //Animation animation = AnimationUtils.loadAnimation(mContext, (position > lastPosition) ? R.anim.fadein : R.anim.fadeout);
        //result.startAnimation(animation);
        lastPosition = position;

        viewHolder.txtName.setText(dataModel.getName());
        viewHolder.txtDesc.setText(dataModel.getDesc());
        viewHolder.txtParPaga.setText(dataModel.getPaga());
        viewHolder.txtParTotal.setText(dataModel.getTotal());
        viewHolder.txtPreco.setText(dataModel.getPreco());
        viewHolder.compl.setOnClickListener(this);
        viewHolder.compl.setTag(position);
        // Return the completed view to render on screen
        return convertView;
    }

    // View lookup cache
    private static class ViewHolder {
        TextView txtName;
        TextView txtDesc;
        TextView txtPreco;
        TextView txtParPaga;
        TextView txtParTotal;
        CheckBox compl;
    }

}