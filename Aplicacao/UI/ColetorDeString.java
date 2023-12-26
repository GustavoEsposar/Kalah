package UI;

public class ColetorDeString {
    public static String funcionamentoJogo(){
        return "No início do jogo, quatro sementes são colocadas em cada casa. Este é o método tradicional.\n" +
                "Cada jogador controla as seis casas e suas sementes no lado do tabuleiro do jogador.\n" +
                "A pontuação do jogador é o número de sementes no armazém à sua direita.\n" +
                "Os jogadores se revezam no plantio de suas sementes.\n" +
                "Num turno, o jogador remove todas as sementes de uma das casas sob seu controle.\n" +
                "Movendo-se no sentido anti-horário, o jogador semeia uma semente em cada casa, incluindo o armazém do próprio jogador, mas não o do oponente.\n" +
                "Se a última semente semeada cair em uma casa vazia de propriedade do jogador, e a casa oposta contiver sementes, tanto a última semente quanto as sementes opostas serão capturadas e colocadas no armazém do jogador.\n" +
                "Se a última semente semeada cair no armazém do jogador, o jogador recebe um turno adicional.\n" +
                "Não há limite para o número de turnos que um jogador pode fazer na sua vez.\n" +
                "Quando um jogador não tiver mais sementes em nenhuma de suas casas, o jogo termina.\n" +
                "Todas as semente do outro jogador são movidas para o armazém do mesmo e o jogador com mais sementes em seu armazém vence.";
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