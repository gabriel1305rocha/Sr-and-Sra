package fourcodes.srsra;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;


public class Login extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void onClickEntra(View view){
        /*startActivity(new Intent (this, Inicio.class));
        finish();*/
        startActivity(new Intent (this, MenuLateral.class));
        finish();
    }

    public void onClickCadastra(View view){
        startActivity(new Intent (this, Dados.class));
    }
}