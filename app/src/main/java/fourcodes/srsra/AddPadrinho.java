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

public class AddPadrinho extends AppCompatActivity {

    Context context = this;
    Button btnSalvar;
    Button btnCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_padrinho);

        FindViews();
        setOnClicks();

        Spinner spinConvi = (Spinner) findViewById(R.id.spinConvidou);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.convidou,android.R.layout.simple_spinner_dropdown_item);
        spinConvi.setAdapter(adapter);
    }

    private void FindViews() {
        btnSalvar = (Button) findViewById(R.id.btnSalvar);
        btnCancelar = (Button) findViewById(R.id.btnCancel);
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
    }
    @Override
    public void onBackPressed() {
        Voltar();
    }
    private void Salvar(){}
    private void Voltar(){
        if(VoltaTela(context, 3)){
            finish();
        }
    }
}
