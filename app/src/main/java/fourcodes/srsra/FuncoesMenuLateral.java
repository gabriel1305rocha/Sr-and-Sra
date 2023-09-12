package fourcodes.srsra;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.renderscript.ScriptGroup;
import android.text.InputType;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.facebook.login.LoginManager;

import static fourcodes.srsra.AddValor.edit;
import static fourcodes.srsra.FragDesItem.Pesquisa;

/**
 * Created by Felipe on 24/03/2017.
 */

public class FuncoesMenuLateral {
    static String pesquisaItem;

    static protected boolean ClickMenuNav(MenuItem item, Context context){
        int id = item.getItemId();

        if (id == R.id.nav_inicio) {
            context.startActivity(new Intent(context, MenuLateral.class));
            return true;
        } else if (id == R.id.nav_checklist) {
            context.startActivity(new Intent(context, Checklist.class));
            return true;
        } else if (id == R.id.nav_padrinho) {
            return false;
        } else if (id == R.id.nav_convidado) {
            context.startActivity(new Intent(context, Convidados.class));
            return true;
        } else if (id == R.id.nav_despesas) {
            context.startActivity(new Intent(context, Despesas.class));
            return true;
        } else if (id == R.id.nav_fornecedor) {
            context.startActivity(new Intent(context, Fornecedor.class));
            return true;
        } else if (id == R.id.nav_configu) {
            context.startActivity(new Intent(context, Configura.class));
            return true;
        } else if (id == R.id.nav_info) {
            context.startActivity(new Intent(context, Sobre.class));
            return true;
        }
        return false;
    }
    static protected boolean ClickMenuOpt(MenuItem item, Context context){
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return false;
        }  else if (id == R.id.nav_sair) {
            LoginManager.getInstance().logOut();
            context.startActivity(new Intent(context, Inicio.class));
            return true;
        } else if (id == R.id.action_add) {
            edit = false;
            context.startActivity(new Intent(context, AddValor.class));
            return true;
        } else if (id == R.id.action_addTarefa) {
            return false;
        } else if (id == R.id.action_pesquisa_item) {
            AlertDialog.Builder pesquisa = new AlertDialog.Builder(context);
            pesquisa.setTitle("Pesuisar Item");
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
            return false;
        }
        return false;
    }
}
