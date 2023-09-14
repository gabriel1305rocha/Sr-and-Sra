package fourcodes.srsra;


import android.content.Context;
import android.content.Intent;

public class ListTarefas {

    static int pos;

    static public void ClickListTarefa(int positionClick, Context context) {
        pos = positionClick;
        context.startActivity(new Intent(context, Tarefas.class));

    }
}
