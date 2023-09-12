package fourcodes.srsra;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.facebook.AccessToken;
import com.facebook.Profile;

public class Splash extends AppCompatActivity implements Runnable {

    static public String NomeUser = "";
    static public String SexoUser = "male";
    static public String NomeParceiro = "Indisponivel";
    static public int StatusLogin = 0;
    /* StatusLogin == 1, Offline
    *  StatusLogin == 2, Facebook
    *  StatusLogin == 3, Email Local
    *  StatusLogin == 4, Logado
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Handler handler = new Handler();
        handler.postDelayed(this, 1000);

    }
    @Override
    public void run() {
        ProximaTela(StatusLogin);
    }

    public void ProximaTela(int status){
        switch (status){
            case 1:
                NomeUser = "";
                startActivity(new Intent (this, MenuLateral.class));
                finish();
                break;
            case 2:
                try {
                    if (AccessToken.getCurrentAccessToken().getUserId() != null){
                        Profile profile = Profile.getCurrentProfile();
                        NomeUser = profile.getFirstName();
                    }
                }catch(Exception ex){
                    NomeUser = "";
                }
                startActivity(new Intent (this, MenuLateral.class));
                finish();
                break;
            case 3:

                startActivity(new Intent (this, MenuLateral.class));
                finish();
                break;
            case 4:
                startActivity(new Intent (this, MenuLateral.class));
                finish();
                break;
            default:
                startActivity(new Intent (this, Inicio.class));
                finish();
                break;
        }
    }
}