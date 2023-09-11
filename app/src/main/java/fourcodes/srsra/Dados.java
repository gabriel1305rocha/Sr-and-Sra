package fourcodes.srsra;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Dados extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
    }

    public void onClickCadastra(View view){
        startActivity(new Intent(this, MenuLateral.class));
        finishActivity(Login.CONTEXT_INCLUDE_CODE);
        finish();
    }
}