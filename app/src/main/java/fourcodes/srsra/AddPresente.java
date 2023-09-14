package fourcodes.srsra;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import static fourcodes.srsra.Categorias.Categoria;
import static fourcodes.srsra.Volta.VoltaTela;

public class AddPresente extends AppCompatActivity {

    Context context = this;
    TextView txtDataEntrega;
    DatePickerDialog entregaDatePickerDialog;
    SimpleDateFormat dateFormatter;
    Button btnSalvar;
    Button btnCancelar;
    ImageButton btnCategoria;
    TextView lblIcon;
    ImageView imgIcon;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_presente);

        dateFormatter = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
        FindViews();
        setDateTimeField();
        setOnClicks();

    }
    private void setDateTimeField() {
        txtDataEntrega.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                entregaDatePickerDialog.show();}
        });

        Calendar newCalendar = Calendar.getInstance();
        entregaDatePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int ano, int mes, int dia) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(ano, mes, dia);
                txtDataEntrega.setText(dateFormatter.format(newDate.getTime()));
            }

        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

    }
    private void FindViews(){
        btnSalvar = (Button) findViewById(R.id.btnSalvar);
        btnCancelar = (Button)findViewById(R.id.btnCancel);
        btnCategoria = (ImageButton)findViewById(R.id.btnCategoria) ;
        lblIcon = (TextView)findViewById(R.id.lblIcon);
        imgIcon = (ImageView)findViewById(R.id.imgIcon);
        txtDataEntrega = (TextView)findViewById(R.id.txtDataEntrega);
        txtDataEntrega.setInputType(InputType.TYPE_NULL);
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
        btnCategoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(context);
                final CustomCategoriaAdapter categoria = Categoria(context);

                builder.setTitle("Escolha a categoria");
                builder.setNegativeButton(R.string.cancelar, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        dialog.cancel();
                    }
                });
                builder.setAdapter(categoria, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int position) {
                        lblIcon.setText(categoria.getItem(position).getCategoria());
                        imgIcon.setImageResource(categoria.getItem(position).getImagen());
                        imgIcon.setVisibility(View.VISIBLE);
                        lblIcon.setVisibility(View.VISIBLE);
                    }
                });
                builder.show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Voltar();
    }
    private void Salvar(){}
    private void Voltar(){
        if(VoltaTela(context, 7)){
            finish();
        }
    }

}