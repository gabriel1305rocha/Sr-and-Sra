package fourcodes.srsra;


import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import static fourcodes.srsra.FuncoesMenuLateral.ClickMenuOpt;
import static fourcodes.srsra.ListTarefas.pos;
import static fourcodes.srsra.TarefaCriaLista.CriaLista;
import static fourcodes.srsra.TarefaCriaLista.titulo;
import static fourcodes.srsra.Volta.VoltaTela;

public class Tarefas extends AppCompatActivity {

    private static CustomAdapterListTarefas adapter;
    ArrayList<DataModelTarefas> dataModels;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarefas);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.canShowOverflowMenu();
        toolbar.setNavigationIcon(R.drawable.ic_back_arrow);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Voltar();
            }
        });

        this.setTitle(R.string.title_tarefas);

        ListView listTarefas = (ListView) findViewById(R.id.list_tarefas);
        listTarefas.setAdapter(CriaLista(pos, this));


        TextView Titulo = (TextView) findViewById(R.id.tituloTarefa);
        Titulo.setText(titulo);
    }

    public void onBackPressed() {
        Voltar();
    }

    private void Voltar() {
        if (VoltaTela(context, 2)) {
            finish();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_add_tarefa, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (ClickMenuOpt(item, this)) {
            finish();
        } else {
            return false;
        }
        return super.onOptionsItemSelected(item);
    }
}
