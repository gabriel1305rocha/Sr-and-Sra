package fourcodes.srsra;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import static fourcodes.srsra.Splash.StatusLogin;


public class Login extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }

    public void onClickEntra(View view) {
        Iniciar();
    }

    public void Iniciar() {
        StatusLogin = 3;
        startActivity(new Intent(this, Splash.class));
        finish();
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, Inicio.class));
        finish();
    }

}