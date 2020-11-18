package ge.edu.btu.server;

import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws Exception {
        ServerSocket serversocket = new ServerSocket(8987);

        Socket socket = serversocket.accept();
        System.out.println("კავშირის დამყარება");

        ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
        while (true) {
            String msg = (String) objectInputStream.readObject();
            System.out.println("დასვი კითხვა:");
            if (msg.equals("გამარჯობა")) {
                System.out.println("გამარჯობა, რით შემიძლია დაგეხმაროთ?");
            } else if (msg.equals("მაჩვენე კურსი")) {
                System.out.println("2.97");
            } else if (msg.equals("მაჩვენე ფილიალები")) {
                System.out.println("ი.ჭავჭავაძე გამზ., ვ.ფშაველა გამზ., გურამიშვილის გამზ.");
            } else if (msg.equals("ნახვამდის")) {
                System.out.println("ნახვამდის");
                break;
            } else {
                System.out.println("სამწუხაროდ ამ კითხვაზე პასუხი არ მაქვს");
            }
        }

        objectInputStream.close();
        serversocket.close();
        System.out.println("სერვერი გამოირთო");
    }
}