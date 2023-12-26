package Modelo;

public class Silo {
    private int nome;
    private int sementes;

    public Silo() {
        nome = 7;
        sementes = 0;
    }

    public void adicionarSemente(int quantidadeDeSementes) { // Toda vez que o Silo receber uma semente essa
        sementes += quantidadeDeSementes;
    }

    public int getQuantidadeSementes(){
        return sementes;
    }

}
