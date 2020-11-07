package Level2.lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

import static Level2.lesson6.Server.ANSI_RED;
import static Level2.lesson6.Server.ANSI_RESET;

public class Client {
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;

    public Client() {
        try {
            System.out.println("Socket is starting up...");
            socket = new Socket("localhost", 8888);
            //System.out.println(socket);

            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            AtomicBoolean isDrop = new AtomicBoolean(false);

            new Thread(() -> {
                try {
                    while (true) {
                        String incomingMessage = in.readUTF();
                        if (incomingMessage.contains("cmd Exit")) {
                            System.out.println(incomingMessage);
                            System.out.println("Please press double enter to close command line...");
                            isDrop.set(true);
                            break;
                        }
                        System.out.println(ANSI_RED + incomingMessage + ANSI_RESET);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();

            Scanner scanner = new Scanner(System.in);
            while (true) {
                if (isDrop.get()) {
                    System.out.println("Closing...");
                    break;
                }
                System.out.println("Please type in a message (or -exit for quit):");
                out.writeUTF("Client say: " + scanner.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Client socket = new Client();
    }
}
