package app.Cliente;

import app.frames.Cliente.ClientInterface;

/**
 * @author Breno Lopes de Lima - 31312514
 * @author Vinicius Dutra Cerqueira Rocha - 315112918
 * @author Kepler Nicolai Alves Freitas  - 31222198
 * @version 5.0
 * 
 */
public class Cliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
 
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new InterfaceAntiga().setVisible(true);
                new ClientInterface().setVisible(true);
            }
        });
    }
}
