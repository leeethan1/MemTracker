import javax.swing.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;


/**
 * @author Abhiram Saran
 * @version 25 Jan 2020
 */

public class ProjectClient {

//    private static Socket socket;
//    private static ObjectOutputStream outputStream;
//    private static ObjectInputStream inputStream;
//
//    public static String hostnameInput() { //don't shout at me for using GUIs I tried my best okay
//
//        return JOptionPane.showInputDialog(null, "Please enter a Hostname",
//                "TITLE", JOptionPane.QUESTION_MESSAGE);
//    }
//
//    public void createOrganiser(){   //Enter name age yadayadayada
//
//    }
//
//    public void enterStaff() {   //use addStaff from Organiser parent class
//
//    }
//
//    public ArrayList<Staff> viewStaff() { //use arraylist above to show staff
//         ArrayList<Staff> temp = new ArrayList<>();
//        return temp;
//                                    //incomplete
//
//    }
//
//    public static void main(String[] args) {  // may/may not have ripped this clean from the project 5 client
//
//        String host;
//        try {
//            host = hostnameInput();
//        } catch (NullPointerException e) {
//            JOptionPane.showMessageDialog(null, "Enter valid Hostname!",
//                    "Invalid Hostname", JOptionPane.ERROR_MESSAGE);
//            return;
//        }
//        System.out.println(host);
//
//        int port = 0;
//        boolean validPort = false;
//        while (!validPort) {
//
//            String portString = "";
//            try {
//                portString = JOptionPane.showInputDialog(null, "Please enter a Port Number",
//                        "TITLE", JOptionPane.QUESTION_MESSAGE);
//            } catch (NullPointerException e) {
//                JOptionPane.showMessageDialog(null, "Enter a valid Port Number!",
//                        "Invalid Port Number", JOptionPane.ERROR_MESSAGE);
//                return;
//            }
//            int characterCounter = 0;
//            for (int i = 0; i < portString.length(); i++) {
//
//                if (!Character.isDigit(portString.charAt(i))) {
//                    characterCounter++;
//                }
//            }
//
//            if (characterCounter > 0) {
//                JOptionPane.showMessageDialog(null, "Enter a valid Port Number!",
//                        "Invalid Port Number", JOptionPane.ERROR_MESSAGE);
//            }
//
//            if (characterCounter == 0) {
//                port = Integer.parseInt(portString);
//                validPort = true;
//            }
//        }
//
//        System.out.println(port);
//
//        try {
//            socket = new Socket(host, port);
//
//            outputStream = new ObjectOutputStream(socket.getOutputStream());
//            inputStream = new ObjectInputStream(socket.getInputStream());
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//
//    }
//
//    private static boolean isParsable(String string) { //trash
//        return string.chars()
//                .mapToObj(Character::isDigit)
//                .reduce(Boolean::logicalAnd)
//                .orElse(Boolean.FALSE);
//    }

}
