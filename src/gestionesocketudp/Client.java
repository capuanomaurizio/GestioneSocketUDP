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
/**
 *
 * @author mauri
 */
public class Client {
    
    int serverPort;
    InetAddress serverIP;
    DatagramSocket dataSocket;
    DatagramPacket inPacket;
    DatagramPacket outPacket;
    byte[] buffer;
    String messaggioDaInviare;
    String messaggioRicevuto;
    String dataCorrente;
    
    public Client(int port, InetAddress IP){
        try {
            serverPort = port;
            serverIP = IP;
            dataSocket = new DatagramSocket();
        } catch (SocketException ex) {
            System.err.print(ex);
        }
    }
    
    public void scrivi(String msg){
        try {
            messaggioDaInviare = msg;
            outPacket = new DatagramPacket(messaggioDaInviare.getBytes(), messaggioDaInviare.length(), serverIP, serverPort);
            dataSocket.send(outPacket);
        } catch (IOException ex) {
            System.err.print(ex);
        }
    }
    
    public String leggi(){
        try {
            buffer = new byte[256];
            inPacket = new DatagramPacket(buffer, buffer.length);
            dataSocket.receive(inPacket);
            messaggioRicevuto = new String(inPacket.getData(), 0, inPacket.getLength());
            return messaggioRicevuto;
        } catch (IOException ex) {
            System.err.print(ex);
            return null;
        }
    }
    
    public void riceviDataCorrente(){
        try {
            buffer = new byte[256];
            inPacket = new DatagramPacket(buffer, buffer.length);
            dataSocket.receive(inPacket);
            dataCorrente = new String(inPacket.getData(), 0, inPacket.getLength());
            System.out.println("Data del server ricevuta: "+dataCorrente);
        } catch (IOException ex) {
            System.err.print(ex);
        }
    }
    
    public void chiudi(){
        dataSocket.close();
    }
}
