/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionesocketudp;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *
 * @author mauri
 */
public class GestioneSocketClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            Client client = new Client(2000, InetAddress.getLocalHost());
            client.scrivi("Richiesta di connessione");
            System.out.println(client.leggi());
        } catch (UnknownHostException ex) {
            System.err.print(ex);
        }
    }
    
}
