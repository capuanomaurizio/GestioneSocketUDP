/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionesocketudp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mauri
 */
public class Server {
    
    int port;
    InetAddress IP;
    int lastClientPort;
    InetAddress lastClientIP;
    DatagramSocket dataSocket;
    DatagramPacket inPacket;
    DatagramPacket outPacket;
    byte[] buffer;
    String messaggioDaInviare;
    String messaggioRicevuto;
    
    public Server(int port){
        try {
            IP = InetAddress.getLocalHost();
            this.port = port;
            dataSocket = new DatagramSocket(this.port);
            System.out.println("Server in ascolto sulla porta " + port);
        } catch (UnknownHostException ex) {
            System.err.print(ex);
        } catch (SocketException ex) {
            System.err.print(ex);
        }
    }
    
    public void scrivi(String msg){
        try {
            messaggioDaInviare = msg;
            outPacket = new DatagramPacket(messaggioDaInviare.getBytes(), messaggioDaInviare.length(), lastClientIP, lastClientPort);
            dataSocket.send(outPacket);
        } catch (IOException ex) {
            System.err.print(ex);
        }
    }
    
    public void leggi(){
        try {
            buffer = new byte[256];
            inPacket = new DatagramPacket(buffer, buffer.length);
            dataSocket.receive(inPacket);
            messaggioRicevuto = new String(inPacket.getData(), 0, inPacket.getLength());
            lastClientIP = inPacket.getAddress();
            lastClientPort = inPacket.getPort();
            System.out.println("IL CLIENT " + lastClientIP + ":" + lastClientPort + " dice: " + messaggioRicevuto);
        } catch (IOException ex) {
            System.err.print(ex);
        }
    }
}
