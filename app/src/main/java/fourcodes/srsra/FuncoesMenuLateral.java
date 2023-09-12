package fourcodes.srsra;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.InputType;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.facebook.login.LoginManager;

import static android.content.Context.INPUT_METHOD_SERVICE;
import static fourcodes.srsra.AddValor.edit;
import static fourcodes.srsra.FragDesItem.Pesquisa;

/**
 * Created by Felipe on 24/03/2017.
 */

public class FuncoesMenuLateral {
    static String pesquisaItem;

    static protected boolean ClickMenuNav(MenuItem item, Context context){
        int id = item.getItemId();

        switch (id) {
            case R.id.nav_inicio:
                context.startActivity(new Intent(context, MenuLateral.class));
                return true;
            case R.id.nav_checklist:
                context.startActivity(new Intent(context, Checklist.class));
                return true;
            case R.id.nav_padrinho:
                context.startActivity(new Intent(context, Padrinhos.class));
                return true;
            case R.id.nav_convidado:
                context.startActivity(new Intent(context, Convidados.class));
                return true;
            case R.id.nav_despesas:
                context.startActivity(new Intent(context, Despesas.class));
                return true;
            case R.id.nav_fornecedor:
                context.startActivity(new Intent(context, Fornecedor.class));
                return true;
            case R.id.nav_configu:
                context.startActivity(new Intent(context, Configura.class));
                return true;
            case R.id.nav_info:
                context.startActivity(new Intent(context, Sobre.class));
                return true;
            case R.id.nav_daminhas:
                context.startActivity(new Intent(context, Daminha.class));
                return true;
            default:
                return false;
        }
    }
    static protected boolean ClickMenuOpt(MenuItem item, final Context context){
        int id = item.getItemId();

        switch (id){
            case R.id.action_settings:
                return false;
            case R.id.nav_sair:
                LoginManager.getInstance().logOut();
                context.startActivity(new Intent(context, Inicio.class));
                return true;
            case R.id.action_add:
                edit = false;
                context.startActivity(new Intent(context, AddValor.class));
                return true;
            case R.id.action_addTarefa:
                return false;
            case R.id.action_pesquisa_item:
                AlertDialog.Builder pesquisa = new AlertDialog.Builder(context);
                pesquisa.setTitle(R.string.pesquisar_item);
                final EditText input = new EditText(context);
                input.setInputType(InputType.TYPE_CLASS_TEXT);
                pesquisa.setView(input);
                pesquisa.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (input.getText().toString().equals("")){
                            dialog.cancel();
                        } else {
                            pesquisaItem = input.getText().toString();
                            Pesquisa(pesquisaItem);
                        }
                    }
                });
                pesquisa.setNegativeButton(R.string.cancelar, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                pesquisa.show();
                input.requestFocus();
                input.postDelayed(new Runnable(){
                                       @Override public void run(){
                                           InputMethodManager keyboard=(InputMethodManager)context.getSystemService(Context.INPUT_METHOD_SERVICE);
                                           keyboard.showSoftInput(input,0);
                                       }
                                   }
                        ,200);

                return false;
            case R.id.action_add_for:
                context.startActivity(new Intent(context, addFornecedor.class));
                return true;
            default:
                return false;
        }
    }
}
