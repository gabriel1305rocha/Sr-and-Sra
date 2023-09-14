package fourcodes.srsra;


import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapterListTarefas extends ArrayAdapter<DataModelTarefas> implements View.OnClickListener {

    Context mContext;
    private ArrayList<DataModelTarefas> dataSet;
    private int lastPosition = -1;


    public CustomAdapterListTarefas(ArrayList<DataModelTarefas> data, Context context) {
        super(context, R.layout.list_tarefa_layout, data);
        this.dataSet = data;
        this.mContext = context;

    }

    @Override
    public void onClick(View v) {

        int position = (Integer) v.getTag();
        Object object = getItem(position);
        DataModelTarefas dataModel = (DataModelTarefas) object;

        switch (v.getId()) {
            case R.id.caixa:

                /*Snackbar.make(v, "Release date " +dataModel.getFeature(), Snackbar.LENGTH_LONG)
                        .setAction("No action", null).show();*/

                break;
        }

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        final DataModelTarefas dataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        final CustomAdapterListTarefas.ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {


            viewHolder = new CustomAdapterListTarefas.ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.list_tarefa_layout, parent, false);
            viewHolder.txtTarefa = (TextView) convertView.findViewById(R.id.nome);
            viewHolder.chkBox = (CheckBox) convertView.findViewById(R.id.caixa);

            result = convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (CustomAdapterListTarefas.ViewHolder) convertView.getTag();
            result = convertView;
        }

        lastPosition = position;

        viewHolder.txtTarefa.setText(dataModel.getTarefa());
        viewHolder.chkBox.setChecked(dataModel.getConcluida());
        if (viewHolder.chkBox.isChecked()) {
            viewHolder.txtTarefa.setPaintFlags(viewHolder.txtTarefa.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        } else {
            viewHolder.txtTarefa.setPaintFlags(viewHolder.txtTarefa.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
        }
        viewHolder.chkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int colorDefault = viewHolder.txtTarefa.getResources().getColor(R.color.TextPrimary);
                int colorMark = viewHolder.txtTarefa.getResources().getColor(R.color.TextMark);
                if (viewHolder.chkBox.isChecked()) {
                    viewHolder.txtTarefa.setPaintFlags(viewHolder.txtTarefa.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                    viewHolder.txtTarefa.setTextColor(colorMark);
                } else {
                    viewHolder.txtTarefa.setPaintFlags(viewHolder.txtTarefa.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
                    viewHolder.txtTarefa.setTextColor(colorDefault);
                }
            }
        });
        // Return the completed view to render on screen
        return convertView;
    }

    // View lookup cache
    private static class ViewHolder {
        TextView txtTarefa;
        CheckBox chkBox;
    }

}