/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionesocketudp;

/**
 *
 * @author mauri
 */
public class GestioneSocketServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Server server = new Server(2000);
        while(true){
            if(server.leggi().equals("data"))
                server.inviaDataCorrente();
            server.scrivi("Benvenuto nuovo client");
        }
        
    }
    
}
