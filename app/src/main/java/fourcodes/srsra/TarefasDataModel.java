package fourcodes.srsra;

/**
 * Created by Felipe on 25/03/2017.
 */

public class TarefasDataModel {

    String tarefa = "";
    boolean concluida;

    public TarefasDataModel(String tarefa, boolean concluida) {
        this.tarefa = tarefa;
        this.concluida = concluida;
    }

    public String getTarefa() {
        return tarefa;
    }

    public boolean getConcluida() {
        return concluida;
    }
}
