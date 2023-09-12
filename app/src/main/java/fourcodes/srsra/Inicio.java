package fourcodes.srsra;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.Profile;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import static fourcodes.srsra.Splash.*;

public class Inicio extends Activity {


    CallbackManager callbackManager = CallbackManager.Factory.create();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        LoginButton BtnFace = (LoginButton) findViewById(R.id.btnLoginFace);
        BtnFace.setReadPermissions("email");
        // If using in a fragment
        //BtnFace.setFragment(this);
        // Other app specific specialization

        // Callback registration
        try {
            if (AccessToken.getCurrentAccessToken().getUserId() != null){
                Profile profile = Profile.getCurrentProfile();
                NomeUser = profile.getFirstName();
                faceBook();
            }
        }catch(Exception ex){
            NomeUser = "";
        }

        BtnFace.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
        @Override
        public void onSuccess(LoginResult loginResult) {
            faceBook();
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
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    public void onClickEntra(View view){
        startActivity(new Intent (this, Login.class));
        finish();
    }

    public void onClickCadastra(View view){
        startActivity(new Intent (this, Cadastro.class));
        finish();
    }

    public void onClickOffLine(View view){
        StatusLogin = 1;
        Home();
    }
    public void faceBook(){
        StatusLogin = 2;
        Home();
    }
    public void Home(){
        startActivity(new Intent(this, Splash.class));
        finish();
    }
}
