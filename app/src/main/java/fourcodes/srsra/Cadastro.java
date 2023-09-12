package fourcodes.srsra;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import static fourcodes.srsra.Splash.StatusLogin;

public class Cadastro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
    }

    public void onClickContinua(View view){
        StatusLogin = 3;
        startActivity(new Intent(this, Cadastro_Cont.class));
        finishActivity(Login.CONTEXT_INCLUDE_CODE);
        finish();
    }
}