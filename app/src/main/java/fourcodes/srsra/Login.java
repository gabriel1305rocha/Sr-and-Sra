package fourcodes.srsra;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.facebook.AccessToken;
import com.facebook.AccessTokenSource;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.Profile;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import static fourcodes.srsra.Splash.StatusLogin;


public class Login extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }

    public void onClickEntra(View view){
        Iniciar();
    }

    public void Iniciar(){
        StatusLogin = 3;
        startActivity(new Intent (this, Splash.class));
        finish();
    }
    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, Inicio.class));
        finish();
    }

}