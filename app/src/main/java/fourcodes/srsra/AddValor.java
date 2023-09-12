package fourcodes.srsra;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class AddValor extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_valor);

        Spinner spinnerDia = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapterDia = ArrayAdapter.createFromResource(this,
                R.array.dias_mes, android.R.layout.simple_spinner_item);
        adapterDia.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDia.setAdapter(adapterDia);

        Spinner spinnerMes = (Spinner) findViewById(R.id.spinnerMes);
        ArrayAdapter<CharSequence> adapterMes = ArrayAdapter.createFromResource(this,
                R.array.meses, android.R.layout.simple_spinner_item);
        adapterMes.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMes.setAdapter(adapterMes);

        Spinner spinnerAno = (Spinner) findViewById(R.id.spinnerAno);
        ArrayAdapter<CharSequence> adapterAno = ArrayAdapter.createFromResource(this,
                R.array.anos, android.R.layout.simple_spinner_item);
        adapterAno.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAno.setAdapter(adapterAno);

    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, Despesas.class));
        finish();
    }

    public void ConfirmNewItem(View view) {
        startActivity(new Intent(this, Despesas.class));
        finish();
    }
    public void CancelNewItem(View view) {
        startActivity(new Intent(this, Despesas.class));
        finish();
    }
}
