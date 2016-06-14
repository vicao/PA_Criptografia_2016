package app.Sistema.Cliente;

import app.Sistema.ChatMessage;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Breno Lopes de Lima - 31312514
 * @author Vinicius Dutra Cerqueira Rocha - 315112918
 * @author Kepler Nicolai Alves Freitas  - 31222198
 * @version 5.0
 * 
 */
public class ClienteService {
    
    private Socket socket;
    private ObjectOutputStream output;
    
    public Socket connect(String server) {
        try {
            this.socket = new Socket(server, 5555);
            this.output = new ObjectOutputStream(socket.getOutputStream());
        } catch (UnknownHostException ex) {
            Logger.getLogger(ClienteService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ClienteService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return socket;
    }
    
    public void send(ChatMessage message) {
        try {
            output.writeObject(message);
        } catch (IOException ex) {
            Logger.getLogger(ClienteService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
