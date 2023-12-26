package Modelo;

public class Fazendeiro {
    private Fazenda fazenda;

    public Fazendeiro() {
        fazenda = new Fazenda();
    }

    public Fazenda getFazenda() {
        return fazenda;
    }

    public boolean temSementes() {
        for (Casa casa : fazenda.getCasas()) {
            if (casa.getQuantidadeSementes() > 0) {
                return true;
            }
        }

        return false;
    }

}
