package fourcodes.srsra;

import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import static fourcodes.srsra.Volta.VoltaTela;

public class AddTarefa extends AppCompatActivity {

    Context context = this;
    Button btnSalvar;
    Button btnCancelar;
    Spinner spinCategoria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_tarefa);

        FindViews();
        setOnClicks();
    }

    private void FindViews() {
        btnSalvar = (Button) findViewById(R.id.btnSalvar);
        btnCancelar = (Button) findViewById(R.id.btnCancel);
        spinCategoria = (Spinner) findViewById(R.id.spinCategoria);
    }
    private void setOnClicks(){
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Salvar();Voltar();
            }
        });
        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Voltar();
            }
        });
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.tarefas_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinCategoria.setAdapter(adapter);
    }
    @Override
    public void onBackPressed() {
        Voltar();
    }
    private void Salvar(){}
    private void Voltar(){
        startActivity(new Intent(this, Tarefas.class));
        finish();
    }
}
