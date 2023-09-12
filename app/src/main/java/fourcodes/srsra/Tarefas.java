package fourcodes.srsra;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

import static fourcodes.srsra.FuncoesMenuLateral.ClickMenuOpt;
import static fourcodes.srsra.ListTarefas.pos;
import static fourcodes.srsra.TarefaCriaLista.CriaLista;

public class Tarefas extends AppCompatActivity {

    ArrayList<TarefasDataModel> dataModels;
    private static CustomListTarefasAdapter adapter;

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
                startActivity(new Intent(Tarefas.this, Checklist.class));
                finish();
            }
        });

        this.setTitle(R.string.title_tarefas);

        ListView listTarefas = (ListView) findViewById(R.id.list_tarefas);
        listTarefas.setAdapter(CriaLista(pos, this));
        /*if(pos==0){
            dataModels= new ArrayList<>();
            dataModels.add(new TarefasDataModel("Escolha a data do casamento", false));
            dataModels.add(new TarefasDataModel("Defina Orçamento", true));
            adapter=new CustomListTarefasAdapter(dataModels, this);
            listTarefas.setAdapter(adapter);
        }else if (pos==1){

        }*/
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, Checklist.class));
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_add_tarefa, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (ClickMenuOpt(item, this)){
            finish();
        } else {
            return false;
        }
        return super.onOptionsItemSelected(item);
    }
}
