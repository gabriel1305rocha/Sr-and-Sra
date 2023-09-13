package fourcodes.srsra;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class addConv extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_convidado);

        //ArrayAdapter<String> spnAcompanhante = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, quantAcompanhente)
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, Convidados.class));
        finish();
    }
}