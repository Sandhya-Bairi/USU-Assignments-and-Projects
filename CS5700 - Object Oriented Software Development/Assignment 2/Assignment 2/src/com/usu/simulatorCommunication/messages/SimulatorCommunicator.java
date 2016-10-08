package com.usu.simulatorCommunication.messages;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

import com.usu.stocks.Portfolio;
import com.usu.stocks.Stock;

public class SimulatorCommunicator {
	
	DatagramSocket clientSocket;
	Portfolio portfolios = new Portfolio();
	
	public void startUDPPacket() throws Exception {
		clientSocket = new DatagramSocket(12099);
		new CommunicatorThread().run();
	}
	
	public void stopUDPPacket() throws SocketException, Exception {
		if(clientSocket != null) {
			clientSocket.close();
			clientSocket = null;
		}
	}
	
	private void Monitoring(Object state) {
		portfolios.put("PIH", new Stock());
        if (portfolios == null)
        	return;
        
        StreamStocksMessage startMessage = new StreamStocksMessage();
        for(String key : portfolios.keySet())
           startMessage.Add(key);
        Send(startMessage);
        
        while (clientSocket.isConnected()) {
            try {
            	portfolios.update(Receive(0));
            }
            catch (Exception e) {
            }
        }
    }
	
	private void Send(StreamStocksMessage message) {
        if (message == null)
        	return;

        byte[] bytesToSend = message.Encode();

        try {
        	clientSocket.send(new DatagramPacket(bytesToSend, bytesToSend.length, InetAddress.getByName("0.0.0.0"), 12099));
        }
        catch (Exception e) {
        }
    }

	
    private TickerMessage Receive(int timeout) throws IOException {
        TickerMessage message = null;

        byte[] receivedPacket = ReceivePacket(timeout);
        if (receivedPacket != null && receivedPacket.length > 0)
            message = TickerMessage.Decode(receivedPacket);

        return message;
    }


    private byte[] ReceivePacket(int timeout) throws IOException {
    	byte[] receivedPacket = new byte[1024];

        clientSocket.setSoTimeout(timeout);
        try {
        	clientSocket.receive(new DatagramPacket(receivedPacket, receivedPacket.length));
        }
        catch (SocketException err) {

        }
        return receivedPacket;
    }
    
    private class CommunicatorThread implements Runnable {

		@Override
		public void run() {
			System.out.println("Inside run");
			Monitoring(new Object());			
		}
    	
    }
}