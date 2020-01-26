import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.io.File;

/**
 * @author Abhiram Saran
 * @version 25 Jan 2020
 */

public class ProjectServer {

    public static final int port = 8080;
    public ServerSocket ss;

    public ProjectServer() throws IOException{
        ss = new ServerSocket(port);
    }

    public static void main(String[] args) {
        ProjectServer server;

        try {
            ProjectServer rs = new ProjectServer();
            rs.serveClients();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void serveClients() {
        Socket clientSocket;
        Thread handlerThread;
        int clientCount = 0;

        System.out.printf("<Now serving clients on port 8080>");

        while (true) {
            try {
                clientSocket = this.ss.accept();
            } catch (IOException e) {
                e.printStackTrace();

                return;
            } //end try catch

            handlerThread = new Thread(new ClientHandler(clientSocket));

            handlerThread.start();

            System.out.printf("<Client %d connected...>%n", clientCount);

            clientCount++;
        }
    }

}
/**
 * @author Abhiram Saran
 * @version 25 Jan 2020
 */

class ClientHandler implements Runnable {
    private Socket socket;
    private HashMap<Event, String> events = new HashMap<Event, String>();
    private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int CODE_LENGTH = 8;


    public ClientHandler(Socket clientSocket) throws NullPointerException {
        this.socket = clientSocket;
    }

    public void run() {
        System.out.println("fml");

        try {
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            StringBuilder eventCode = new StringBuilder();
            String line;
            Event ev;

//            FileInputStream fileIn = new FileInputStream("eventlist.txt");
//            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
//            Object event;
//
//            fileIn.close();
//            objectIn.close();

//            while ((event = objectIn.readObject()) != null) {
//                events.put((Event) event, (String) objectIn.readObject());
//            }

            while ((line = (String) ois.readObject()) != null) {
                System.out.println(line);
                switch (line) {
                    case "CREATE":
                        line = (String) ois.readObject();
                        System.out.println(line);
                        ev = new Event(line);
                        for (int i = 0; i < CODE_LENGTH; i++) {
                            eventCode.append(ALPHA_NUMERIC_STRING.charAt(
                                    (int) (Math.random() * ALPHA_NUMERIC_STRING.length())
                            ));
                        }
                        System.out.println(eventCode);
                        line = (String) ois.readObject();
                        System.out.println(line);
                        ev.setOrganizer(line);
                        events.put(ev, eventCode.toString());

                        oos.writeObject(eventCode.toString());
                        oos.flush();
                        break;
                    case "ADD":
                        line = (String) ois.readObject();
                        if (events.containsValue(line)) {
                            for (Map.Entry<Event, String> entry : events.entrySet()) {
                                if (entry.getValue().equals(line)) {
                                    entry.getKey().addHelper((String) ois.readObject());

                                    oos.writeObject("success");
                                    oos.flush();
                                    break;
                                }
                            }
                        } else {
                            oos.writeObject("fail");
                            oos.flush();
                        }
                        break;

                }
            }
            ois.close();
            oos.close();

//            FileOutputStream fos = new FileOutputStream("eventlist.txt");
//            ObjectOutputStream obstream = new ObjectOutputStream(fos);
//
//            for (Map.Entry<Event, String> entry : events.entrySet()) {
//                obstream.writeObject(entry.getKey());
//                obstream.flush();
//                obstream.writeObject(entry.getValue());
//                obstream.flush();
//            }

//            fos.close();
//            obstream.close();

        } catch (EOFException e) {
            System.out.println("DONE!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
