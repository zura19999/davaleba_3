package ge.edu.btu.client;

import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class CLient {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        Socket socket = new Socket("localhost", 8987);
        System.out.println("კავშირის დამყარება");

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        String msg = scanner.nextLine();
        objectOutputStream.writeObject(msg);

        objectOutputStream.close();
        socket.close();
    }
}