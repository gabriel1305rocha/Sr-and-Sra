package fourcodes.srsra;

import android.content.Context;
import java.util.ArrayList;


public class TarefaCriaLista {
    static ArrayList<TarefasDataModel> dataModels;
    private static CustomListTarefasAdapter adapter;
    public static  String titulo="";

    private static String[] tarefaT = {"Um ano Antes","Dez meses antes","Oito meses antes","Seis meses antes","Três meses antes","Dois meses antes","Um mês antes","Quinze dias antes","Uma semana Antes","Dois dias antes","Um dia antes","O grande dia!","Na volta da Lua de MEl"};
    private static String[] tarefa1 = {"Escolha a data do casamento","Defina Orçamento","Decida as características da cerimônia. Observação: o horário define o estilo","Defina a quantidade de convidados","Escolha o local da cerimônia e festa","Se for contratar serviço de um cerimonial,esta é a hora certa de escolher o profissional","Decida onde vocês vão morar e , se for necessario,comece a procurar um lugar","Comece a preparar seu enxoval","Contrate o Bufé","Comece a pesquisar a música da igreja e da festa"};
    private static String[] tarefa2 = {"Comece a preparar a lista de convidados","Faça pesquisas de locais para lua de mel","Visite lojas e estilistas e procure modelos de vestidos","Neste peíodo, é aconselhável que sejam feitos todos os exames de saúde","Escolha o profissional que vai fazer a maquiagem e cabelos e reserve a data","Contrate o DJ, a banda ou músico(s) e defina a(s) música(s) da sua cerimônia"};
    private static String[] tarefa3 = {"Contrate o decorador e a empresa responsável pela iluminação","Pesquise preços de convites","Comece a degustar os espumantes para o seu casamento e a pesquisar preço"};
    private static String[] tarefa4 = {"Convide os padrinhos e a(s) dama(s) de honra e o(s) pajem(ns)","Defina o seu estilista e o seu vestido","Conclua a lista de convidados","Defina o bufê e o cardápio","Defina o roteiro para a lua de mel","Caso aida não tenha providenciado as alianças, esta é a hora","Escolha o bolo, docinhos, chocolate e bem casados","Faça a reserva da noite de núpcias", "Verifique se a documentação para cartório já está correta e decidida qual regime de bens será adotado:comunhão parcial, comunhão universal ou separação total de bens","Contrate o aluguel de carros, se necessário"};
    private static String[] tarefa5 = {"Encomende os convites e contrate o calígrafo. Deverá ser entregue uma lista exclusivamente para o serviço de caligrafia.Obsevação: o prazo de entrega dos convites pelo calígrafo é de, geralemente, uma semana","Comece a preparar a lista de presentes e a pesquisar lojas para deixá-las","Compre as lembrancinhas e os brindes","Faça a prova do vestido","Faça a compra do sapato ou alugue","Escolha e encomente os buquês(o damigreja, o de jogar e o das damas)","Providencie as roupas do noivo e dos padrinhos e encomende as flores de lapela","Compre o presente do seu noivo(a)","Hora de ir ao cartório para dar início ao processo do casamento civil","Confira com a agência de viagens se será preciso tomar alguma vacina antes de viajar de lua de mel"};
    private static String[] tarefa6 = {"Comece a enviar os convites, dando preferência aos que moram mais longe, para que possam providenciar hospedagem","Escolha e reserve o local que vai passar o dia do casamento.Pode ser uma suíte de hotel, um salão de beleza ou sua casa","Defina que carro levaá a noiva para a cerimônia (caso não contrate o aluguel de carros)","Converse com os profissionais contrados e defina o roteiro da festa","Converse com os profissionais contratados e defina o retoiro da festa","É elegante entregar os convites pessoalmente, o que nem sempre é possível. Mas quanto aos padrinhos e aos pais de pajens e damas de honra, é fundamental que os convites sejam entregues pessoalmente","Combine os detalhes com os amigos para o chá de panela,chá de lingerie e chá bar"};
    private static String[] tarefa7 = {"Termine de entregar os convites","Verifique o local da recepção e faça os acertos finais: pessoal de apoio para portaria, banheiro e estacionamento","Agende a depilação, pedicure e manicure","Ao receber os presentes, aproveite para escrever os cartões de agradecimento","Lembre-se de comprar uma langerie especial para o dia e uma para a lua de mel","Faça o chá de panela, chá de lingerie e de bar e aproveite","Comece a levar os pertences dos noivos para a nova moradia","O cerimonial deve confirmar todos os profissionais e serviços envolvidos no casamento","Faça a lista do que vai levar para lua de mel","Dê uma assessoria aos convidados de fora da sua cidade e confirme se eles precisam de ajuda"};
    private static String[] tarefa8 = {"Faça a ultima prova do vestido","Faça a prova de maquiagem e cabelo juntamente com os acessórios(tiara,véu,coroa)","Cheque a mudança de nome dos documentos","Comece a arrumar as malas para a lua de mel","Marque uma reunião com o cerimonial para montar o cronograma do casamento e acerte os detalhes pendentes", "Escolha uma pessoa de confiança que ficará responsável por devolver o vestido e o traje do noivo, se alugados, no dia seguinte à cerimônia","Mande gravar os nomes nas alianças e dar polimento","Dê algumas voltas com o sapato pela casa para amaciá-lo"};
    private static String[] tarefa9 = {"Momento do ensaio geral, com pais, padrinhos, noivos, damas de honra e pajens","Marque um encontro com o responsável pela música (DJ, banda ou músico(s)) e passe para ele(s) a lista de músicas que não podem faltar na sua festa","Marque um jantar com os pais e padrinhos, para depois do ensaio","O noivo deve combinar com alguém que possa levá-lo à cerimônia"};
    private static String[] tarefa10 = {""};
    private static String[] tarefa11 = {""};
    private static String[] tarefa12 = {""};
    private static String[] tarefa13 = {""};

    private static boolean[] tarefaVer = {false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false};

    static public CustomListTarefasAdapter CriaLista(int position, Context context){
        String [][]tarefas = new String[13][];
        tarefas[0] = tarefa1;
        tarefas[1] = tarefa2;
        tarefas[2] = tarefa3;
        tarefas[3] = tarefa4;
        tarefas[4] = tarefa5;
        tarefas[5] = tarefa6;
        tarefas[6] = tarefa7;
        tarefas[7] = tarefa8;
        tarefas[8] = tarefa9;
        tarefas[9] = tarefa10;
        tarefas[10] = tarefa11;
        tarefas[11] = tarefa12;
        tarefas[12] = tarefa13;

        titulo = tarefaT[position];


        dataModels= new ArrayList<>();
        for (int i=0; i<tarefas[position].length && i<tarefaVer.length; i++){
            dataModels.add(new TarefasDataModel(tarefas[position][i], tarefaVer[i]));
        }
        adapter = new CustomListTarefasAdapter(dataModels, context);

        return adapter;
    }

}
