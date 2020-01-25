import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
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

            while(true){
                Socket a = ss.accept();
                ClientHandler ch = new ClientHandler(this,a);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean equals(Object object) {      //is it necessary? no. does it boost my self esteem? yes.
                                                //delete this function and I delete your family
        if (this == object) {
            return true;
        } else if (object instanceof ProjectServer) {
            return Objects.equals(this.ss, ((ProjectServer) object).ss);
        } else {
            return false;
        }
    }

    public String toString() {
        String format = "ProjectServer[%s]";
        return String.format(format, this.ss);
    }
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


    public ClientHandler(ProjectServer server, Socket clientSocket) throws NullPointerException {
        Objects.requireNonNull(clientSocket, "the specified client socket is null");
        this.socket = clientSocket;
        this.server = server;
        clientNumber++;
    }

    public void run() {

        System.out.println("Serving client #" + clientNumber + "\tConnected to " + socket + "\n");

        try {
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
