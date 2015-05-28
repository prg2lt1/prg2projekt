/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameControl;

import Opponent.NetworkPlayer;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 *
 * @author tobias
 */
public class Network {

    private byte[] data = new byte[1024];
    private DatagramSocket socket;
    private InetAddress address;
    private int port;
    private String serverIp = "192.168.1.119";
    private int ServerPort = 5500;

    /**
     * Kommuniziert mit dem Server um eine InetAddresse eines anderen Spielers
     * zu bekommen. Speichert Addresse und Port in den Variabeln oben. Stellt
     * die IP und den Port des anderen Spielers ein.
     */
    public void Network() {

        //Server ansprechen
        try {
            socket = new DatagramSocket(ServerPort);
        } catch (SocketException e) {
            System.out.println("Socket failed " + e.getMessage());
        }

        try {
            address = InetAddress.getByName((String) this.serverIp);
        } catch (UnknownHostException e) {
            System.out.println("unknown IP " + e.getMessage());
        }

        sendData("It's a-me...");

        //Auf Antwort von Server warten:
        System.out.println(receiveServerData());
    }

    public void sendData(String newData) {
        data = newData.getBytes();

        DatagramPacket packet = new DatagramPacket(data, data.length, address, this.port);
        try {
            socket.send(packet);
        } catch (IOException e) {
            System.out.println("IO fail while sending packet " + e.getMessage());
        }
        System.out.println("sent");
    }

    public String receiveData() {
        System.out.println("wait for data IO");
        DatagramPacket packet = new DatagramPacket(data, data.length);

        try {
            socket.receive(packet);
        } catch (IOException e) {
            System.out.println("IO fail while sending packet " + e.getMessage());
        }

        data = packet.getData();
        int len = packet.getLength();

        System.out.println("received data" + data);
        String strData = new String(data, 0, len);

        return (strData);
    }

    public String receiveServerData() {
        System.out.println("wait for Server data IO");
        DatagramPacket packet = new DatagramPacket(data, data.length);

        try {
            socket.receive(packet);
        } catch (IOException e) {
            System.out.println("IO fail while sending packet " + e.getMessage());
        }

        data = packet.getData();
        int len = packet.getLength();

        System.out.println("received data" + data);
        String strData = new String(data, 0, len);
        String[] tmp = strData.split(" ");

        System.out.println("ip " + tmp[0]);
        System.out.println("port " + tmp[1]);

        try {
            this.address = InetAddress.getByName(tmp[0]);
        } catch (UnknownHostException e) {
            System.out.println("unknown IP " + e.getMessage());
        }

        this.port = Integer.getInteger(tmp[1]);
        return (strData);
    }

    public boolean playTurn() {
        System.out.println(receiveData());
        // mit Anweisungen in data Spielzug machen.
        return true;
    }

   
}
