package fourcodes.srsra;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomListTarefasAdapter extends ArrayAdapter<TarefasDataModel> implements View.OnClickListener{

    private ArrayList<TarefasDataModel> dataSet;
    Context mContext;

    // View lookup cache
    private static class ViewHolder {
        TextView txtTarefa;
        CheckBox chkBox;
    }



    public CustomListTarefasAdapter(ArrayList<TarefasDataModel> data, Context context) {
        super(context, R.layout.list_tarefa_layout, data);
        this.dataSet = data;
        this.mContext=context;

    }


    @Override
    public void onClick(View v) {

        int position=(Integer) v.getTag();
        Object object= getItem(position);
        TarefasDataModel dataModel=(TarefasDataModel)object;

        switch (v.getId())
        {
            case R.id.caixa:

                /*Snackbar.make(v, "Release date " +dataModel.getFeature(), Snackbar.LENGTH_LONG)
                        .setAction("No action", null).show();*/

                break;
        }


    }

    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        TarefasDataModel dataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        CustomListTarefasAdapter.ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {


            viewHolder = new CustomListTarefasAdapter.ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.list_tarefa_layout, parent, false);
            viewHolder.txtTarefa = (TextView) convertView.findViewById(R.id.nome);
            viewHolder.chkBox = (CheckBox) convertView.findViewById(R.id.caixa);

            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (CustomListTarefasAdapter.ViewHolder) convertView.getTag();
            result=convertView;
        }

        lastPosition = position;


        viewHolder.txtTarefa.setText(dataModel.getTarefa());
        viewHolder.chkBox.setChecked(dataModel.getConcluida());
        // Return the completed view to render on screen
        return convertView;
    }


}
