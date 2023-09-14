package fourcodes.srsra;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

import static fourcodes.srsra.Volta.VoltaTela;

public class AddConvidado extends AppCompatActivity {

    Context context = this;
    Button btnSalvar;
    Button btnCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_convidado);
        FindViews();
        setOnClicks();
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
        if(VoltaTela(context, 4)){
            finish();
        }
    }
}