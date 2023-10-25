package Modelo;

public class Casa {
    private int quantidadeDeSementes;
    private int id;
    private Sementes quantSementes = new Sementes(quantidadeDeSementes);;

    public Casa(int id) {
        this.id = id;
        quantSementes.setquantidadeDeSementes(0);
    }

    public int getID(){
        return id;
    }

    /**
     * Pega a quantidadeDeSementes de sementes
     */
    public int getQuantidadeSementes() {
        return quantidadeDeSementes;
    }

    /**
     * Adiciona sementes dentro da casa
     * 
     * @param quantidadeDeSementes -> sementes
     */
    public void adicionarSementes(int quantidadeDeSementes) {
        quantSementes.adicionarSementes(quantidadeDeSementes);
    }

    /**
     * remove sementes dentro de uma casa
     * 
     * @param quantidadeDeSementes -> sementes
     */
    public void removerSementes(int quantidadeDeSementes) {
        quantSementes.removerSementes(quantidadeDeSementes);
    }

    public String toString() {
        return "Casa: " + quantidadeDeSementes + " sementes";
    }
}
