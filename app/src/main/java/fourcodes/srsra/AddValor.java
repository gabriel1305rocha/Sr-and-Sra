package fourcodes.srsra;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Switch;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import static fourcodes.srsra.EditarItem.*;
import static fourcodes.srsra.FragDesItem.ItemsdataModels;
import static fourcodes.srsra.Volta.VoltaTela;


public class AddValor extends Activity {

    String textDialog = "0";
    Context context = this;
    static boolean edit;

    Spinner spinDia;

    EditText txtNome;
    EditText txtValor;
    EditText txtAnota;
    Button btnSalvar;
    Button btnCancelar;
    Button txtParce;
    Button txtParcePaga;
    Button btnData;
    EditText txtDataInicio;
    EditText txtDataTermi;

    RelativeLayout dataTermi;
    Switch swtPago;

    DatePickerDialog inicioDatePickerDialog;
    DatePickerDialog termiDatePickerDialog;

    SimpleDateFormat dateFormatter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_valor);
        FindViews();
        setOnClicks();
        SpinnersAdapters();
        ButtonsParcelas();

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

        dateFormatter = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
        setDateTimeField();

        if(edit){
            seEditando();
        }
    }
    private void setDateTimeField() {
        txtDataInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inicioDatePickerDialog.show();}
        });
        txtDataTermi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                termiDatePickerDialog.show();}
        });

        Calendar newCalendar = Calendar.getInstance();
        inicioDatePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int ano, int mes, int dia) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(ano, mes, dia);
                txtDataInicio.setText(dateFormatter.format(newDate.getTime()));
            }

        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
        termiDatePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int ano, int mes, int dia) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(ano,mes,dia);
                txtDataTermi.setText(dateFormatter.format(newDate.getTime()));
            }
        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

    }
    private void FindViews(){
        spinDia = (Spinner) findViewById(R.id.spinner2);

        txtNome = (EditText) findViewById(R.id.ItemNome);
        txtValor = (EditText) findViewById(R.id.ItemValor);
        txtAnota = (EditText)findViewById(R.id.txtItemAnotacao);
        txtParce = (Button) findViewById(R.id.txtItemParcela);
        txtParcePaga = (Button) findViewById(R.id.txtItemParcelaPaga);
        swtPago = (Switch) findViewById(R.id.swtItemPago);

        dataTermi = (RelativeLayout) findViewById(R.id.ItemDataTermi);
        txtDataInicio = (EditText) findViewById(R.id.txtDataInicio);
        txtDataInicio.setInputType(InputType.TYPE_NULL);
        txtDataTermi = (EditText) findViewById(R.id.txtDataTermi);
        txtDataTermi.setInputType(InputType.TYPE_NULL);

        btnSalvar = (Button) findViewById(R.id.btnSalvar);
        btnCancelar = (Button) findViewById(R.id.btnCancel);
    }
    private void setOnClicks(){
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Salvar();Voltar();
            }
        });
        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Voltar();
            }
        });
    }
    private void SpinnersAdapters(){
        ArrayAdapter<CharSequence> adapterDia = ArrayAdapter.createFromResource(this,
                R.array.dias_mes, android.R.layout.simple_spinner_item);
        adapterDia.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinDia.setAdapter(adapterDia);
    }
    private void ButtonsParcelas(){
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
    }

    @Override
    public void onBackPressed() {
        Voltar();
    }

    public void Salvar() {

        if(edit)
            Editou(posi);
        else
            Adicionou();

        Voltar();
    }
    public void Voltar() {
        if(VoltaTela(context, 1)){
            finish();
        }
    }
    // Define Numero nos campos das Parcelas
    public void InsertDialogText(boolean paga){
        int parPaga = Integer.parseInt(txtParcePaga.getText().toString()), par = Integer.parseInt(txtParce.getText().toString());
        swtPago.setChecked(false);
        swtPago.setEnabled(false);
        if(!paga){
            if(Integer.parseInt(textDialog) <= 1){
                txtParce.setText("1");
                dataTermi.setVisibility(View.GONE);
            }else{
                txtParce.setText(textDialog);
                dataTermi.setVisibility(View.VISIBLE);
            }
            if(parPaga >= Integer.parseInt(textDialog)){
                parPaga = Integer.parseInt(textDialog);
                txtParcePaga.setText(""+parPaga);
                dataTermi.setVisibility(View.GONE);
                swtPago.setEnabled(true);
                swtPago.setChecked(true);
            }else {
                dataTermi.setVisibility(View.VISIBLE);
            }
        }else{
            parPaga = Integer.parseInt(textDialog);
            if(parPaga <= 0){
                txtParcePaga.setText("0");
                dataTermi.setVisibility(View.VISIBLE);
            }else {
                if(parPaga >= par){
                    parPaga = par;
                    txtParcePaga.setText(""+parPaga);
                    dataTermi.setVisibility(View.GONE);
                    swtPago.setEnabled(true);
                    swtPago.setChecked(true);
                }else {
                    dataTermi.setVisibility(View.VISIBLE);
                }
                txtParcePaga.setText(""+parPaga);
            }
        }
    }
    private String[] pegarTextos(){

        String nome,desc,preco,paga,total,dataInicio,dataTermino,diaVen;

        dataInicio = txtDataInicio.getText().toString();
        dataTermino = txtDataTermi.getText().toString();
        diaVen = (spinDia.getAdapter().getItem(spinDia.getSelectedItemPosition()).toString());

        nome = txtNome.getText().toString();
        desc = txtAnota.getText().toString();
        preco = txtValor.getText().toString();
        paga = txtParcePaga.getText().toString();
        total = txtParce.getText().toString();

        return new String[]{nome,desc,preco,paga,total,dataInicio,dataTermino,diaVen};
    }
    private void seEditando(){
        txtDataInicio.setText(dateFormatter.format(DateFormat.DATE_FIELD));
        txtDataTermi.setText(dateFormatter.format(DateFormat.DATE_FIELD));
        spinDia.setSelection(3);

        txtNome.setText(texto);
        txtAnota.setText(desc);
        txtValor.setText(valor);
        txtParce.setText(total);
        txtParcePaga.setText(paga);
    }
    private void Editou(int position){
        ItemsdataModels.set(position, new ItemDataModel(pegarTextos()[0],pegarTextos()[1],pegarTextos()[2],pegarTextos()[3],pegarTextos()[4],pegarTextos()[5],pegarTextos()[6],pegarTextos()[7]));
    }
    private void Adicionou(){
        ItemsdataModels.add(new ItemDataModel(pegarTextos()[0],pegarTextos()[1],pegarTextos()[2],pegarTextos()[3],pegarTextos()[4],pegarTextos()[5],pegarTextos()[6],pegarTextos()[7]));
    }
}