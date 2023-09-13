package fourcodes.srsra;

import android.content.Intent;
import android.database.DataSetObserver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

public class AddPadrinho extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_padrinho);

        Button btnCancel = (Button) findViewById(R.id.btnCancel);
        Button btnSalvar = (Button) findViewById(R.id.btnSalvar);

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Volta();
            }
        });
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Salvar();
                Volta();
            }
        });

        Spinner spinConvi = (Spinner) findViewById(R.id.spinConvidou);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.convidou,android.R.layout.simple_spinner_dropdown_item);
        spinConvi.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        Volta();
    }
    private void Salvar(){

    }
    private void Volta(){
        startActivity(new Intent(this, Padrinhos.class));
        finish();
    }
}
