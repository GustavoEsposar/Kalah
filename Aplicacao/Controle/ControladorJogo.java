package Controle;

import Modelo.Casa;
import Modelo.Fazenda;
import Modelo.Fazendeiro;
import UI.IMenu;

import javax.swing.JOptionPane;

public class ControladorJogo {

    private Fazendeiro f1;
    private Fazendeiro f2;

    private ProcessadorDeJogada processadorJogada;

    private IMenu menu;

    public enum FinalizadoresJogada {
        CASA_NORMAL,
        CASA_VAZIA,
        SILO
    }
    public Casa casaFinal;

    public ControladorJogo() {
        f1 = new Fazendeiro();
        f2 = new Fazendeiro();

        criarMenu();

        processadorJogada = new ProcessadorDeJogada(f1, f2, menu);
    }

    public Fazendeiro getF1() {
        return f1;
    }

    public Fazendeiro getF2() {
        return f2;
    }

    public void iniciarJogo() {
        System.out.println("Jogo iniciado");

        /*
        Condicoes de fim do jogo:
        - Quando um jogador nao tiver mais sementes em nenhuma de suas casas
        - Quando um jogador tiver mais de 24 sementes em seu silo
        */

        while (f1.temSementes() && f2.temSementes()) {
            Fazendeiro semeando = processadorJogada.getFazendeiroSemeando(); // Pega o fazendeiro que esta semeando

            /*
             *  Vez do Jogador
             *  Escolher uma casa
             *  Semeiar
             *  Trocar de turno
             */

            System.out.println("Vez do jogador");
            if (semeando == getF1()){
                System.out.println("Jogador 1");
            }else{
                System.out.println("Jogador 2");
            }

            System.out.println("Escolha uma casa");

            Casa casaEscolhida = semeando.getFazenda().getCasa(Integer.parseInt(JOptionPane.showInputDialog("Casa")));
            while (casaEscolhida.getQuantidadeSementes() == 0) {
                System.out.println("Casa vazia, escolha outra");
                casaEscolhida = semeando.getFazenda().getCasa(Integer.parseInt(JOptionPane.showInputDialog("Casa")));
            }
            FinalizadoresJogada finalizador = semear(casaEscolhida);

            switch (finalizador) {
                case SILO:
                    break;
                
                case CASA_VAZIA:
                    apropriacao(casaFinal);
            
                default:
                    processadorJogada.trocarTurno();
                    break;
            }
        }

        System.out.println("Fim de jogo");

        f1.getFazenda().transferirSementesSilo();
        f2.getFazenda().transferirSementesSilo();

        if (f1.getFazenda().getSilo().getQuantidadeSementes() > f2.getFazenda().getSilo().getQuantidadeSementes()) {
            menu.definirVencedor(1);
        } else if (f1.getFazenda().getSilo().getQuantidadeSementes() < f2.getFazenda().getSilo().getQuantidadeSementes()) {
            menu.definirVencedor(2);
        } else {
            menu.definirVencedor(3);
        }

    }

    public FinalizadoresJogada semear(Casa aPartir){
        Fazendeiro semeando = processadorJogada.getFazendeiroSemeando(); // Pega o fazendeiro que esta semeando
        Fazendeiro esperando = processadorJogada.getFazendeiroEsperando(); // Pega o fazendeiro que esta esperando

        int sementes = aPartir.getQuantidadeSementes(); // Pega a quantidade de sementes da casa
        aPartir.removerSementes(sementes); // Remove todas as sementes da casa

        Fazenda fazendaAtual = semeando.getFazenda();

        Casa casaAtual = aPartir;

        FinalizadoresJogada jogadaFinal = FinalizadoresJogada.CASA_NORMAL;

        // Enquanto ainda tiver sementes para semear e a casa atual nao for nula (silo)
        while (sementes > 0) {
            
            Casa proximaCasa = fazendaAtual.pegarProximaCasa(casaAtual); // Pega a proxima casa

            if(proximaCasa == null){
                fazendaAtual.getSilo().adicionarSemente(1); // Adiciona uma semente no silo
                jogadaFinal =  FinalizadoresJogada.SILO;

                if (fazendaAtual == semeando.getFazenda()){ // Se a fazenda atual for a do jogador que esta semeando
                    fazendaAtual = esperando.getFazenda(); // Troca para a fazenda do jogador que esta esperando
                }else{
                    fazendaAtual = semeando.getFazenda();
                }
                
                casaAtual  = proximaCasa; // Pega a primeira casa da fazenda
                sementes--;

            }else{
                casaAtual = proximaCasa;

                if (casaAtual.getQuantidadeSementes() == 0 && fazendaAtual == semeando.getFazenda()) { // Se a casa atual estiver vazia e a fazenda atual for a do jogador que esta semeando
                    jogadaFinal = FinalizadoresJogada.CASA_VAZIA;
                    casaFinal = casaAtual;
                }else{
                    jogadaFinal = FinalizadoresJogada.CASA_NORMAL;
                }

                proximaCasa.adicionarSementes(1); // Adiciona uma semente na proxima casa
                sementes--;
            }
            
            try {
                Thread.sleep(500); // Sleep for 1 second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return jogadaFinal;
    }

    public void apropriacao(Casa casaF){
        Fazendeiro semeando = processadorJogada.getFazendeiroSemeando(); // Pega o fazendeiro que esta semeando
        Fazendeiro esperando = processadorJogada.getFazendeiroEsperando(); // Pega o fazendeiro que esta esperando

        Casa casaEquivalenteAdv = esperando.getFazenda().getCasa(7 - casaF.getNome()); // Pega a casa equivalente do adversario

        int sementes = casaEquivalenteAdv.getQuantidadeSementes(); // Pega a quantidade de sementes da casa equivalente do adversario

        if (sementes > 0){
            casaEquivalenteAdv.removerSementes(sementes); // Remove todas as sementes da casa equivalente do adversario
            casaF.removerSementes(1); // Remove uma semente da casa do jogador que esta semeando
            semeando.getFazenda().getSilo().adicionarSemente(sementes + 1); // Adiciona as sementes da casa equivalente do adversario e a semente removida da casa do jogador que esta semeando no silo do jogador que esta semeando
        }
    }

    public void criarMenu(){
        menu = new IMenu(this);

        // Create a new thread to run the menu logic
        Thread menuThread = new Thread(() -> {

            while (true) {
                menu.atualizar();
            }
        });
        
        // Start the thread
        menuThread.start();
    }

}
