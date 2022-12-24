import java.io.*;
import java.net.*;

class Server {

    ServerSocket serverSocket;
    Socket socket;
    BufferedReader br;
    PrintWriter pout;

    // Constructor
    public Server() {
        try {
            serverSocket = new ServerSocket(7777);
            System.out.println("Server is ready to accept connections");
            System.out.println("Waiting for connections...");

            // Accept connections
            socket = serverSocket.accept();

            // Read and write messages
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            pout = new PrintWriter(socket.getOutputStream());

            // Function for Read and write messages
            startReading();
            startWriting();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Read the message from the client (socket)
    public void startReading() throws IOException {
        // Thread -- Read the message from the client
        Runnable r1 = () -> {
            System.out.println("Read the  message from the client...");

            // Read the infinit message from the client
            while (true) {
                try {
                    String msg = br.readLine();
                    if(msg.equals("exit")){
                        System.out.println("Client terminated the chat");
                        break;
                    }

                    System.out.println("Client: " + msg);	
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
    }

    // write the message to the client (socket)
    public void startWriting() throws IOException {
        // Thread -- Write the message to the client
        Runnable r2 = () -> {
            
        };
    }

    public static void main(String[] args) {
        System.out.println("Server is starting...");
        Server s = new Server();
    }
}