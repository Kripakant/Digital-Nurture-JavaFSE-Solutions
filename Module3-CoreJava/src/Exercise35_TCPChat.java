// Exercise 35: TCP Client-Server Chat
// Objective: Use Java sockets for TCP communication.
//
// HOW TO RUN (two terminals, from the out/ directory):
//   Terminal 1 (server):  java Exercise35_TCPChat server
//   Terminal 2 (client):  java Exercise35_TCPChat client
//
// Type messages in the client terminal; the server echoes/replies.
// Type "bye" to end the conversation.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Exercise35_TCPChat {

    private static final int PORT = 5000;

    // ---------------- SERVER ----------------
    static void runServer() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server listening on port " + PORT + " ...");
            try (Socket socket = serverSocket.accept();
                 BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                 Scanner console = new Scanner(System.in)) {

                System.out.println("Client connected.");
                String clientMsg;
                while ((clientMsg = in.readLine()) != null) {
                    System.out.println("Client: " + clientMsg);
                    if (clientMsg.equalsIgnoreCase("bye")) {
                        break;
                    }
                    System.out.print("Server (you): ");
                    String reply = console.nextLine();
                    out.println(reply);
                    if (reply.equalsIgnoreCase("bye")) {
                        break;
                    }
                }
            }
        }
    }

    // ---------------- CLIENT ----------------
    static void runClient() throws IOException {
        try (Socket socket = new Socket("localhost", PORT);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             Scanner console = new Scanner(System.in)) {

            System.out.println("Connected to server on port " + PORT + ".");
            String userInput;
            while (true) {
                System.out.print("Client (you): ");
                userInput = console.nextLine();
                out.println(userInput);
                if (userInput.equalsIgnoreCase("bye")) {
                    break;
                }
                String serverMsg = in.readLine();
                if (serverMsg == null || serverMsg.equalsIgnoreCase("bye")) {
                    break;
                }
                System.out.println("Server: " + serverMsg);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            System.out.println("Usage: java Exercise35_TCPChat [server|client]");
            return;
        }
        switch (args[0].toLowerCase()) {
            case "server" -> runServer();
            case "client" -> runClient();
            default -> System.out.println("Unknown mode: " + args[0]);
        }
    }
}
