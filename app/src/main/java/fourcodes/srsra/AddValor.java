package fourcodes.srsra;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Switch;

import static fourcodes.srsra.EditarItem.*;
import static fourcodes.srsra.FragDesItem.ItemsdataModels;


public class AddValor extends Activity {

    String textDialog = "0";
    final Context context = this;
    static boolean edit;

    Spinner spinMesI;
    Spinner spinAnoI;
    Spinner spinMesT;
    Spinner spinAnoT;
    Spinner spinDia;

    EditText txtNome;
    EditText txtValor;
    EditText txtAnota;
    Button txtParce;
    Button txtParcePaga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_valor);

        spinMesI = (Spinner) findViewById(R.id.spinnerMes);
        spinAnoI = (Spinner) findViewById(R.id.spinnerAno);
        spinMesT = (Spinner) findViewById(R.id.spinnerMesTermi);
        spinAnoT = (Spinner) findViewById(R.id.spinnerAnoTermi);
        spinDia = (Spinner) findViewById(R.id.spinner2);

        txtNome = (EditText) findViewById(R.id.ItemNome);
        txtValor = (EditText) findViewById(R.id.ItemValor);
        txtAnota = (EditText)findViewById(R.id.txtItemAnotacao);
        txtParce = (Button) findViewById(R.id.txtItemParcela);
        txtParcePaga = (Button) findViewById(R.id.txtItemParcelaPaga);

        ArrayAdapter<CharSequence> adapterDia = ArrayAdapter.createFromResource(this,
                R.array.dias_mes, android.R.layout.simple_spinner_item);
        adapterDia.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinDia.setAdapter(adapterDia);

        ArrayAdapter<CharSequence> adapterMes = ArrayAdapter.createFromResource(this,
                R.array.meses, android.R.layout.simple_spinner_item);
        adapterMes.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinMesI.setAdapter(adapterMes);

        ArrayAdapter<CharSequence> adapterAno = ArrayAdapter.createFromResource(this,
                R.array.anos, android.R.layout.simple_spinner_item);
        adapterAno.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinAnoI.setAdapter(adapterAno);

        spinMesT.setAdapter(adapterMes);

        spinAnoT.setAdapter(adapterAno);

        // Função de clicar no campo de parcelas
        txtParce.setOnClickListener(new View.OnClickListener() {
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
                input.requestFocus();
                input.postDelayed(new Runnable(){
                                      @Override public void run(){
                                          InputMethodManager keyboard=(InputMethodManager)context.getSystemService(Context.INPUT_METHOD_SERVICE);
                                          keyboard.showSoftInput(input,0);
                                      }
                                  },200);
            }
        });

        // Função de clicar no campo de parcelas pagas
        txtParcePaga.setOnClickListener(new View.OnClickListener() {
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
                input.requestFocus();
                input.postDelayed(new Runnable(){
                                      @Override public void run(){
                                          InputMethodManager keyboard=(InputMethodManager)context.getSystemService(Context.INPUT_METHOD_SERVICE);
                                          keyboard.showSoftInput(input,0);
                                      }
                                  },200);
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

        if(edit){
            seEditando();
        }
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, Despesas.class));
        finish();
    }

    public void ConfirmNewItem(View view) {

        if(edit)
            Editou(posi);
        else
            Adicionou();

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

    private String[] pegarTextos(){

        String nome,desc,preco,cater,paga,total,anoIni,mesIni,anoTer,mesTer,diaVen;

        anoIni = (spinAnoI.getAdapter().getItem(spinAnoI.getSelectedItemPosition()).toString());
        mesIni = (spinMesI.getAdapter().getItem(spinMesI.getSelectedItemPosition()).toString());
        mesTer = (spinMesT.getAdapter().getItem(spinMesT.getSelectedItemPosition()).toString());
        anoTer = (spinAnoT.getAdapter().getItem(spinAnoT.getSelectedItemPosition()).toString());
        diaVen = (spinDia.getAdapter().getItem(spinDia.getSelectedItemPosition()).toString());

        nome = txtNome.getText().toString();
        desc = txtAnota.getText().toString();
        preco = txtValor.getText().toString();
        cater = "";
        paga = txtParcePaga.getText().toString();
        total = txtParce.getText().toString();

        return new String[]{nome,desc,preco,cater,paga,total};
    }

    private void seEditando(){
        spinMesI.setSelection(3);
        spinAnoI.setSelection(3);
        spinMesT.setSelection(3);
        spinAnoT.setSelection(3);
        spinDia.setSelection(3);

        txtNome.setText(texto);
        txtAnota.setText(desc);
        txtValor.setText(valor);
        txtParce.setText(total);
        txtParcePaga.setText(paga);
    }
    private void Editou(int position){
        ItemsdataModels.set(position, new ItemDataModel(pegarTextos()[0],pegarTextos()[1],pegarTextos()[2],pegarTextos()[3],pegarTextos()[4],pegarTextos()[5]));
    }
    private void Adicionou(){
        ItemsdataModels.add(new ItemDataModel(pegarTextos()[0],pegarTextos()[1],pegarTextos()[2],pegarTextos()[3],pegarTextos()[4],pegarTextos()[5]));
    }
}