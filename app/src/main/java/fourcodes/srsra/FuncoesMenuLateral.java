package fourcodes.srsra;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;
import com.facebook.login.LoginManager;

/**
 * Created by Felipe on 24/03/2017.
 */

public class FuncoesMenuLateral {
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
            return false;
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
            context.startActivity(new Intent(context, AddValor.class));
            return true;
        }
        return false;
    }
}
