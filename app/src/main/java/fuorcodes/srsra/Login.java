package fuorcodes.srsra;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class Login extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void onClickEntra(View view){
        startActivity(new Intent (this, Inicio.class));
        finish();
    }

    public void onClickCadastra(View view){
        startActivity(new Intent (this, Cadastro.class));
        finish();
    }
}
