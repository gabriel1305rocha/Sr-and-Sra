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



public class Login extends Activity {


    CallbackManager callbackManager = CallbackManager.Factory.create();
    static public String NomeUser = "";
    static public String SexoUser = "male";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        LoginButton BtnFace = (LoginButton) findViewById(R.id.btnLoginFace);
        BtnFace.setReadPermissions("email");
        // If using in a fragment
        //BtnFace.setFragment(this);
        // Other app specific specialization

        // Callback registration
        BtnFace.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                // App code
                //loginResult.getAccessToken().getUserId();
                //NomeUser = Profile.getCurrentProfile().getName();
                Iniciar();
            }

            @Override
            public void onCancel() {
                // App code
            }

            @Override
            public void onError(FacebookException exception) {
                // App code
            }
        });

        try {
            if (AccessToken.getCurrentAccessToken().getUserId() != null){
                Profile profile = Profile.getCurrentProfile();
                NomeUser = profile.getName();
                Iniciar();
            }
        }catch(Exception ex){
            NomeUser = "pp";
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    public void onClickEntra(View view){
        /*startActivity(new Intent (this, Inicio.class));
        finish();*/
        Iniciar();
    }

    public void onClickCadastra(View view){
        startActivity(new Intent (this, Cadastro.class));
    }

    public void Iniciar(){
        startActivity(new Intent (this, MenuLateral.class));
        finish();
    }

}