package fourcodes.srsra;

/**
 * Created by Felipe on 24/03/2017.
 */

public class DataModelItem {

    String name;
    String desc;
    String preco;
    String paga;
    String total;
    String dataInicial;
    String dataTermino;
    String diaVenci;

    public DataModelItem(String name, String desc, String preco, String paga, String total, String dataInicial, String dataTermino, String diaVenci) {
        this.name = name;
        this.desc = desc;
        this.preco = preco;
        this.paga = paga;
        this.total = total;
        this.dataInicial = dataInicial;
        this.dataTermino = dataTermino;
        this.diaVenci = diaVenci;
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

    public String getPaga() {
        return paga;
    }

    public String getTotal() {
        return total;
    }

    public String getDataInicial() {
        return dataInicial;
    }

    public String getDataTermino() {
        return dataTermino;
    }

    public String getDiaVenci() {
        return diaVenci;
    }
}