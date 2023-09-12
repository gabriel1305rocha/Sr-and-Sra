package fourcodes.srsra;

/**
 * Created by Felipe on 24/03/2017.
 */

public class ItemDataModel {

    String name;
    String desc;
    String preco;
    String categoria;
    String paga;
    String total;

    public ItemDataModel(String name, String desc, String preco, String categoria, String paga, String total ) {
        this.name=name;
        this.desc=desc;
        this.preco=preco;
        this.categoria=categoria;
        this.paga=paga;
        this.total=total;

    }


    public String getName() {
        return name;
    }


    public String getDesc() {
        return desc;
    }


    public String getPreco() {
        return preco;
    }


    public String getCategoria() {
        return categoria;
    }


    public String getPaga() {
        return paga;
    }


    public String getTotal() {
        return total;
    }

}