package UI;

public class ColetorDeString {
    public static String funcionamentoJogo(){
        return "No início do jogo, quatro sementes são colocadas em cada casa. Este é o método tradicional. Cada jogador controla as seis casas e suas sementes no lado do tabuleiro do jogador. A pontuação do jogador é o número de sementes na loja à sua direita. Os jogadores se revezam no plantio de suas sementes. Num turno, o jogador remove todas as sementes de uma das casas sob seu controle. Movendo-se no sentido anti-horário, o jogador deixa cair uma semente em cada casa, incluindo a loja do próprio jogador, mas não a do oponente. Se a última semente semeada cair em uma casa vazia de propriedade do jogador, e a casa oposta contiver sementes, tanto a última semente quanto as sementes opostas serão capturadas e colocadas no armazém do jogador. Se a última semente semeada cair na loja do jogador, o jogador recebe um movimento adicional. Não há limite para o número de movimentos que um jogador pode fazer no seu turno. Quando um jogador não tiver mais sementes em nenhuma de suas casas, o jogo termina. O outro jogador move todas as sementes restantes para sua loja e o jogador com mais sementes em sua loja vence.";
    }

    public static String sairDoJogo(){
        return "Sair do Kalah";
    }

    public static String selecionarCasa(){
        return "Selecionar Casa";
    }

    public static String fazendeiroQueMaisColetou(int fazendeiro){
        return String.format("O fazendeiro %d coletou mais sementes!", fazendeiro);
    }

    public static String turnoDoFazendeiro(int fazendeiro){
        return String.format("É a vez do fazendeiro %d!", fazendeiro);
    }
}