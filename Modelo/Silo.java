package Modelo;

public class Silo {
    private Sementes quantSementes_Fazendeiro;

    public Silo() {
        // precisa ter um ID
        quantSementes_Fazendeiro = new Sementes(0); // Jogo iniciado, 0 sementes no silo
    }

    public void SementesColocadas_Silo(int quantidadeDeSementes) { // Toda vez que o Silo receber uma semente essa
                                                                   // classe deve ser utilizada
        quantSementes_Fazendeiro.adicionarSementes(quantidadeDeSementes);
    }

}
