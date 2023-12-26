package Modelo;

public class Casa {
    private int nome;
    private int sementes;

    public Casa(int id) {
        this.nome = id;
        sementes = 4;
    }

    public int getNome(){
        return nome;
    }

    /**
     * Pega a quantidadeDeSementes de sementes
     */
    public int getQuantidadeSementes() {
        return sementes;
    }

    /**
     * Adiciona sementes dentro da casa
     * 
     * @param quantidadeDeSementes -> sementes
     */
    public void adicionarSementes(int quantidadeDeSementes) {
        sementes += quantidadeDeSementes;
    }

    /**
     * remove sementes dentro de uma casa
     * 
     * @param quantidadeDeSementes -> sementes
     */
    public void removerSementes(int quantidadeDeSementes) {
        sementes -= quantidadeDeSementes;
    }

    public String toString() {
        return "Casa: " + sementes + " sementes";
    }
}
