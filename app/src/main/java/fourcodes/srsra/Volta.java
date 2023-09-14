package fourcodes.srsra;

import android.content.Context;
import android.content.Intent;


/**
 * Created by Felipe on 05/04/2017.
 */

public class Volta {
    static public boolean VoltaTela(Context context, int Tela) {
        context.startActivity(new Intent(context, MenuLateral.class));
        switch (Tela) {
            case 0:
                MenuLateral.setPosition(0);
                return true;
            case 1:
                MenuLateral.setPosition(1);
                return true;
            case 2:
                MenuLateral.setPosition(2);
                return true;
            case 3:
                MenuLateral.setPosition(3);
                return true;
            case 4:
                MenuLateral.setPosition(4);
                return true;
            case 5:
                MenuLateral.setPosition(5);
                return true;
            case 6:
                MenuLateral.setPosition(6);
                return true;
            case 7:
                MenuLateral.setPosition(7);
                return true;
            case 8:
                MenuLateral.setPosition(8);
                return true;
            case 9:
                MenuLateral.setPosition(9);
                return true;
            default:
                return false;
        }
    }
}
