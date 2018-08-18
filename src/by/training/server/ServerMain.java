package by.training.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {

    public static void main(String argv[])
    {

        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8989);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                ServerWorker worker = new ServerWorker(clientSocket);
                worker.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

