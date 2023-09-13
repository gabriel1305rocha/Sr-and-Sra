package fourcodes.srsra;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AddDama extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_dama);

        Button btnCancel = (Button) findViewById(R.id.btnCancel);
        Button btnSalvar = (Button) findViewById(R.id.btnSalvar);

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                VoltaActivity();
            }
        });
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Salva();
                VoltaActivity();
            }
        });
    }
    @Override
    public void onBackPressed() {
        VoltaActivity();
    }
    private void Salva(){

    }
    private void VoltaActivity(){
        startActivity(new Intent(this, Daminha.class));
        finish();
    }
}
