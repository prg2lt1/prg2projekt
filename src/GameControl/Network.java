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

    public Network() {
        super("user2", "127.0.0.1", 5500);

        try {
            socket = new DatagramSocket(5500);
        } catch (SocketException e) {
            System.out.println("Socket failed " + e.getMessage());
        }

        try {
            address = InetAddress.getByName((String) this.getIp());
        } catch (UnknownHostException e) {
            System.out.println("unknown IP " + e.getMessage());
        }

        sendData("Hello World");
        System.out.println(receiveData());
    }

    public void sendData(String newData) {
        data = newData.getBytes();
        
        DatagramPacket packet = new DatagramPacket(data, data.length, address, this.getPort());
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
        String[] tmp = strData.split(" ");
        
        System.out.println("ip " + tmp[0]);
        System.out.println("port " + tmp[1]);
        
        return (strData);
    }

    @Override
    public boolean playTurn() {
        System.out.println(receiveData());
        // mit Anweisungen in data Spielzug machen.
        return true;
    }

    public static void main(String[] args){
        Network nw = new Network();
    }
}
