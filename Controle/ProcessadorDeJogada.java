package Controle;

import Modelo.Fazendeiro;
import UI.IMenu;

public class ProcessadorDeJogada {

    private Fazendeiro fazendeiroSemeando;
    private Fazendeiro fazendeiroEsperando;
    private IMenu menu;

    public ProcessadorDeJogada(Fazendeiro fazendeiroInicial, Fazendeiro fazendeiroSecundario, IMenu menu) {
        fazendeiroSemeando = fazendeiroInicial;
        fazendeiroEsperando = fazendeiroSecundario;
        this.menu = menu;
    }

    public void trocarTurno(){
        Fazendeiro aux = fazendeiroSemeando;
        fazendeiroSemeando = fazendeiroEsperando;
        fazendeiroEsperando = aux;
        menu.trocarJogador();
    }

    public Fazendeiro getFazendeiroSemeando(){
        return fazendeiroSemeando;
    }

    public Fazendeiro getFazendeiroEsperando(){
        return fazendeiroEsperando;
    }
}
