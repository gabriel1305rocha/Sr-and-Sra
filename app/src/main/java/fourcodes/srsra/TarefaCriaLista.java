package fourcodes.srsra;

import android.content.Context;
import java.util.ArrayList;


public class TarefaCriaLista {
    static ArrayList<TarefasDataModel> dataModels;
    private static CustomListTarefasAdapter adapter;
    //String [][]tarefas = new String[][]{{"0","1","2","3","4","5","6","7","8","9","10","11"},{""}};

    private static String[] tarefa1 = {"Escolha a data do casamento","Defina Orçamento","Decida as características da cerimônia.\n Observação: o horário define o estilo","Defina a quantidade de convidados","Escolha o local da cerimônia e festa","Se for contratar serviço de um cerimonial,esta é a hora certa de escolher o profissional","Decida onde voc~es vão morar e , se for necessario,comece a procurar um lugar","Comece a preparar seu enxoval","Contrate o Bufé","Comece a pesquisar a música da igreja e da festa"};
    private static String[] tarefa2 = {"Escolha a dat","Defina Orçamento","Decidrísticas da cerimônia.\n Observação: o horário define o estilo","Defina a quantidade de convidados","Escolha o local da cerimônia e festa","Se for contratar serviço de um cerimonial,esta é a hora certa de escolher o profissional","Decida onde voc~es vão morar e , se for necessario,comece a procurar um lugar","Comece a preparar seu enxoval","Contrate o Bufé","Comece a pesquisar a música da igreja e da festa"};
    private static boolean[] tarefaVer = {false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false};

    static public CustomListTarefasAdapter CriaLista(int position, Context context){
        String [][]tarefas = new String[12][];
        tarefas[0] = tarefa1;
        tarefas[1] = tarefa2;
        tarefas[2] = new String[10];
        tarefas[3] = new String[10];
        tarefas[4] = new String[10];

        if(position==0){
            dataModels= new ArrayList<>();
            for (int i=0; i<tarefas[0].length && i<tarefaVer.length; i++){
                dataModels.add(new TarefasDataModel(tarefas[0][i], tarefaVer[i]));
            }
            adapter = new CustomListTarefasAdapter(dataModels, context);
        }else {
            dataModels= new ArrayList<>();
            for (int i=0;i<tarefas[1].length;i++){
                dataModels.add(new TarefasDataModel(tarefas[1][i], tarefaVer[i]));
            }
            adapter = new CustomListTarefasAdapter(dataModels, context);
        }

        return adapter;
    }

}
