package com.example.memtracker;

import android.os.AsyncTask;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class client extends AsyncTask<Void, Void, Void> {
    private Socket socket;
    private String message;
    private String nameOfEvent;
    private String nameOfUser;

    public client(String event, String user) {
        super();
        nameOfEvent = event;
        nameOfUser = user;
    }


    @Override
    protected Void doInBackground(Void... params) {
        try {
            System.out.println("trying to connect");
            socket = new Socket("10.0.2.2", 8080); // connect to the server
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

            oos.writeObject("CREATE");
            oos.flush();
            oos.writeObject(nameOfEvent);
            oos.flush();
            oos.writeObject(nameOfUser);
            oos.flush();

            message = (String) ois.readObject();
            System.out.println(message);

            ois.close();
            oos.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getMessage() {
        return message;
    }

}
