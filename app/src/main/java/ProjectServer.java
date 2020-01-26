import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author Abhiram Saran
 * @version 25 Jan 2020
 */

public class ProjectServer {

    public static final int port = 69420;  // ( ͡° ͜ʖ ͡°)
    public ServerSocket ss;

    public static void main(String[] args) {
        ProjectServer server;

        try {
            server = new ProjectServer();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ProjectServer() {
        try {
            ss = new ServerSocket(port);

            while (true) {
                Socket a = ss.accept();
                ClientHandler ch = new ClientHandler(this, a);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public boolean equals(Object object) {      //is it necessary? no. does it boost my self esteem? yes.
//                                                //delete this function and I delete your family
//        if (this == object) {
//            return true;
//        } else if (object instanceof ProjectServer) {
//            return Objects.equals(this.ss, ((ProjectServer) object).ss);
//        } else {
//            return false;
//        }
//    }

//    public String toString() {
//        String format = "ProjectServer[%s]";
//        return String.format(format, this.ss);
//    }
}

/**
 * @author Abhiram Saran
 * @version 25 Jan 2020
 */

class ClientHandler implements Runnable {   //I don't know if we'll need a client handler but it's 5 AM and at this point
    //I don't give a shit we did it for one of the homeworks
    private Socket socket;
    private ProjectServer server;
    private int clientNumber = 0;
    private HashMap<Event, String> events = new HashMap<Event, String>();
    private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int CODE_LENGTH = 8;


    public ClientHandler(ProjectServer server, Socket clientSocket) throws NullPointerException {
        this.socket = clientSocket;
        this.server = server;
        clientNumber++;
    }

    public void run() {

        System.out.println("Serving client #" + clientNumber + "\tConnected to " + socket + "\n");

        try {
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            StringBuilder eventCode = new StringBuilder();
            String line;
            Event ev;

            FileInputStream fileIn = new FileInputStream("eventlist.txt");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            Object event;

            fileIn.close();
            objectIn.close();

            while ((event = objectIn.readObject()) != null) {
                events.put((Event) event, (String) objectIn.readObject());
            }

            while ((line = (String) ois.readObject()) != null) {
                switch (line) {
                    case "CREATE":
                        line = (String) ois.readObject();
                        ev = new Event(line);
                        for (int i = 0; i < CODE_LENGTH; i++) {
                            eventCode.append((int) Math.random() * ALPHA_NUMERIC_STRING.length());
                        }
                        ev.setOrganizer((String) ois.readObject());
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
            FileWriter fw = new FileWriter("eventlist.txt", false);
            fw.close();
            FileOutputStream fos = new FileOutputStream("eventlist.txt");
            ObjectOutputStream obstream = new ObjectOutputStream(fos);

            for (Map.Entry<Event, String> entry : events.entrySet()) {
                obstream.writeObject(entry.getKey());
                obstream.flush();
                obstream.writeObject(entry.getValue());
                obstream.flush();
            }

            fos.close();
            obstream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
