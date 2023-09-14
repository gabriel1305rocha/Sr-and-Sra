package fourcodes.srsra;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.InputType;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import static fourcodes.srsra.AddValor.edit;
import static fourcodes.srsra.FragDesItem.Pesquisa;

/**
 * Created by Felipe on 24/03/2017.
 */

public class FuncoesMenuLateral {
    static String pesquisaItem;

    static protected boolean ClickMenuOpt(MenuItem item, final Context context) {
        int id = item.getItemId();

        switch (id) {
            case R.id.action_add:
                edit = false;
                context.startActivity(new Intent(context, AddValor.class));
                return true;
            case R.id.action_addTarefa:
                context.startActivity(new Intent(context, AddTarefa.class));
                return true;
            case R.id.action_pesquisa_item:
                AlertDialog.Builder pesquisa = new AlertDialog.Builder(context);
                pesquisa.setTitle(R.string.pesquisar_item);
                final EditText input = new EditText(context);
                input.setInputType(InputType.TYPE_CLASS_TEXT);
                pesquisa.setView(input);
                pesquisa.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (input.getText().toString().equals("")) {
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
                input.postDelayed(new Runnable() {
                                      @Override
                                      public void run() {
                                          InputMethodManager keyboard = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
                                          keyboard.showSoftInput(input, 0);
                                      }
                                  }
                        , 200);

                return false;
            case R.id.action_add_for:
                context.startActivity(new Intent(context, addFornecedor.class));
                return true;
            case R.id.action_add_dama:
                context.startActivity(new Intent(context, AddDama.class));
                return true;
            case R.id.action_add_padrinho:
                context.startActivity(new Intent(context, AddPadrinho.class));
                return true;
            case R.id.action_add_presente:
                context.startActivity(new Intent(context, AddPresente.class));
                return true;
            case R.id.action_add_conv:
                context.startActivity(new Intent(context, AddConvidado.class));
                return true;
            default:
                return false;
        }
    }
}
