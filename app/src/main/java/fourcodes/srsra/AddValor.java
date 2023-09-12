package fourcodes.srsra;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;


public class AddValor extends Activity {

    String textDialog = "0";
    final Context context = this;

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

        Spinner spinnerMesTermi = (Spinner) findViewById(R.id.spinnerMesTermi);
        spinnerMesTermi.setAdapter(adapterMes);

        Spinner spinnerAnoTermi = (Spinner) findViewById(R.id.spinnerAnoTermi);
        spinnerAnoTermi.setAdapter(adapterAno);

        // Função de clicar no campo de parcelas
        Button parcela =(Button) findViewById(R.id.txtItemParcela);
        parcela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle(R.string.numero_de_parcelas);
                // Set up the input
                final EditText input = new EditText(context);
                // Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
                input.setInputType(InputType.TYPE_CLASS_NUMBER);
                builder.setView(input);
                // Set up the buttons
                builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (input.getText().toString().equals("")){
                            dialog.cancel();
                        } else {
                            textDialog = input.getText().toString();
                        }
                        InsertDialogText(false);
                    }
                });
                builder.setNegativeButton(R.string.cancelar, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                builder.show();
            }
        });

        // Função de clicar no campo de parcelas pagas
        Button parcelaPaga =(Button) findViewById(R.id.txtItemParcelaPaga);
        parcelaPaga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle(R.string.numero_de_parcelas_pagas);

                final EditText input = new EditText(context);

                input.setInputType(InputType.TYPE_CLASS_NUMBER);
                builder.setView(input);

                builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (input.getText().toString().equals("")){
                            dialog.cancel();
                        } else {
                            textDialog = input.getText().toString();
                        }
                        InsertDialogText(true);
                    }
                });
                builder.setNegativeButton(R.string.cancelar, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                builder.show();
            }
        });
        final Switch swtPago = (Switch) findViewById(R.id.swtItemPago);
        swtPago.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    swtPago.setTextColor(getResources().getColor(R.color.TextPrimary));
                }else{
                    swtPago.setTextColor(getResources().getColor(R.color.hintColor));
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, Despesas.class));
        finish();
    }

    public void ConfirmNewItem(View view) {

        /*Spinner spinnerMesI = (Spinner) findViewById(R.id.spinnerMes);
        Spinner spinnerAnoI = (Spinner) findViewById(R.id.spinnerAno);
        Spinner spinnerMesT = (Spinner) findViewById(R.id.spinnerMesTermi);
        Spinner spinnerAnoT = (Spinner) findViewById(R.id.spinnerAnoTermi);
        int anoIni = Integer.parseInt(spinnerAnoI.getAdapter().getItem(spinnerAnoI.getSelectedItemPosition()).toString());
        int mesIni = Integer.parseInt(spinnerAnoI.getAdapter().getItem(spinnerAnoI.getSelectedItemPosition()).toString());*/

        startActivity(new Intent(this, Despesas.class));
        finish();
    }
    public void CancelNewItem(View view) {
        startActivity(new Intent(this, Despesas.class));
        finish();
    }

    // Define Numero nos campos das Parcelas
    public void InsertDialogText(boolean paga){
        Button editText = (Button) findViewById(R.id.txtItemParcela);
        Button editTextPaga = (Button) findViewById(R.id.txtItemParcelaPaga);
        RelativeLayout dataTermi = (RelativeLayout) findViewById(R.id.ItemDataTermi);
        Switch swtPago = (Switch) findViewById(R.id.swtItemPago);
        int parPaga = Integer.parseInt(editTextPaga.getText().toString()), par = Integer.parseInt(editText.getText().toString());
        swtPago.setChecked(false);
        swtPago.setEnabled(false);
        if(!paga){
            if(Integer.parseInt(textDialog) <= 1){
                editText.setText("1");
                dataTermi.setVisibility(View.GONE);
            }else{
                editText.setText(textDialog);
                dataTermi.setVisibility(View.VISIBLE);
            }
            if(parPaga >= Integer.parseInt(textDialog)){
                parPaga = Integer.parseInt(textDialog);
                editTextPaga.setText(""+parPaga);
                dataTermi.setVisibility(View.GONE);
                swtPago.setEnabled(true);
                swtPago.setChecked(true);
            }else {
                dataTermi.setVisibility(View.VISIBLE);
            }
        }else{
            parPaga = Integer.parseInt(textDialog);
            if(parPaga <= 0){
                editTextPaga.setText("0");
                dataTermi.setVisibility(View.VISIBLE);
            }else {
                if(parPaga >= par){
                    parPaga = par;
                    editTextPaga.setText(""+parPaga);
                    dataTermi.setVisibility(View.GONE);
                    swtPago.setEnabled(true);
                    swtPago.setChecked(true);
                }else {
                    dataTermi.setVisibility(View.VISIBLE);
                }
                editTextPaga.setText(""+parPaga);
            }
        }
    }
}