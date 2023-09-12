package fourcodes.srsra;

import android.content.Context;
import android.content.Intent;

import static fourcodes.srsra.AddValor.edit;

public class EditarItem {
    static String texto="", desc="", valor="", paga="", total="",venci="", DataIMes="", DataIAno="", DataTMes="", DataTAno="";
    static int posi;

    public EditarItem(int position, Context context, String texto, String desc, String valor, String paga, String total){
        this.posi = position;
        this.texto = texto;
        this.desc = desc;
        this.valor = valor;
        this.paga = paga;
        this.total = total;
        edit = true;
        context.startActivity(new Intent(context, AddValor.class));
    }

    protected int getPosi() {
        return posi;
    }
    protected String getTexto() {
        return texto;
    }
    protected String getDesc() {
        return desc;
    }
    protected String getPaga() {
        return paga;
    }
    protected String getTotal() {
        return total;
    }
    protected String getValor() {
        return valor;
    }
    protected static String getDataIAno() {
        return DataIAno;
    }
    protected static String getDataIMes() {
        return DataIMes;
    }
    protected static String getDataTAno() {
        return DataTAno;
    }
    protected static String getDataTMes() {
        return DataTMes;
    }
    protected static String getVenci() {
        return venci;
    }
}
