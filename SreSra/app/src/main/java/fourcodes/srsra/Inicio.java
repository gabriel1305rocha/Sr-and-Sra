package fourcodes.srsra;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Inicio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        String nomeNoivo = "Joanésio";
        String nomeNoiva = "@string/senha";

        TextView nomeSr = (TextView) findViewById(R.id.lblNomeNoivo);
        TextView nomeSra = (TextView) findViewById(R.id.lblNomeNoiva);
        TextView diaResta = (TextView) findViewById(R.id.lblDiaResta);
        ProgressBar barraDia = (ProgressBar) findViewById(R.id.progressBar);

        nomeSr.setText("Sr. "+nomeNoivo);
        nomeSra.setText("Sra. "+nomeNoiva);
    }
}