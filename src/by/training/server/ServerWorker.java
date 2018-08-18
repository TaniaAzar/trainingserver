package by.training.server;

import javax.script.ScriptException;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerWorker extends Thread {

    private final Socket clientSocket;

    public ServerWorker(Socket clientSocket){
        this.clientSocket = clientSocket;
    }

    @Override
    public void run(){
        try {
            handleClientSocket();
        } catch (IOException | InterruptedException | ScriptException e) {
            e.printStackTrace();
        }
    }

    public void handleClientSocket() throws IOException, InterruptedException, ScriptException {
        BufferedReader inFromClient = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        DataOutputStream outToClient = new DataOutputStream(clientSocket.getOutputStream());

        String clientLine = inFromClient.readLine();
        Person person = new Person(clientLine);
        String name = person.getName();
        System.out.println(clientLine);

        Thread.sleep(1000);
        String outServerLine = "{\"message\":\"Hello, " + name + "\"}\n";

        outToClient.writeBytes(outServerLine);
        clientSocket.close();
    }
}
