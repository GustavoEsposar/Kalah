import Controle.ControladorJogo;

/**
 * Aplicacao
 */
public class Aplicacao {

    private static ControladorJogo controlador;

    public static void main(String[] args) {
        controlador = new ControladorJogo();

        controlador.iniciarJogo();
    }
}