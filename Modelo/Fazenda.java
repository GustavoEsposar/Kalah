package Modelo;

import java.util.ArrayList;

public class Fazenda {
    private ArrayList<Casa> casas;
    private Silo silo;

    public Fazenda() {
        casas = new ArrayList<Casa>();

        for (int i = 1; i <= 6; i++) {
            casas.add(new Casa(i)); // Adiciona as 6 casas
        }

        silo = new Silo();
    }

    public ArrayList<Casa> getCasas() {
        return casas;
    }

    public Silo getSilo() {
        return silo;
    }

    public Casa pegarProximaCasa(Casa aPartir){
        if (aPartir == null){
            return casas.get(0);
        }
        int index = casas.indexOf(aPartir);
        index++;
        if(index == casas.size()){
            return null;
        }
        return casas.get(index);
    }

    public Casa getCasa(int id) {
        return casas.get(id - 1);
    }

    public void transferirSementesSilo(){
        int quantidadeSementes = 0;
        for (var casa : casas){
            quantidadeSementes += casa.getQuantidadeSementes();
            casa.removerSementes(quantidadeSementes);
        }

        silo.adicionarSemente(quantidadeSementes);
    }

}
