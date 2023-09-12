package fourcodes.srsra;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static fourcodes.srsra.Splash.*;

public class Cadastro_Cont extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro__cont);
    }

    public void onClickContinua(View view){

        EditText nomeNoiva = (EditText) findViewById(R.id.txtNome);
        EditText nomeNoivo = (EditText) findViewById(R.id.txtNomeNoivo);

        NomeUser = nomeNoivo.getText().toString();
        NomeParceiro = nomeNoiva.getText().toString();

        startActivity(new Intent(this, MenuLateral.class));
        finishActivity(Login.CONTEXT_INCLUDE_CODE);
        finish();
    }
}