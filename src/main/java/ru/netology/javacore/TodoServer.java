package ru.netology.javacore;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TodoServer {
    private int port;
    private Todos todos;

    public TodoServer(int port, Todos todos) {
        this.port = port;
        this.todos = todos;
    }

    public void start() throws IOException {
        System.out.println("Starting server at " + port + "...");
        try (ServerSocket serverSocket = new ServerSocket(port);) {
            while (true) {
                try (
                        Socket socket = serverSocket.accept();
                        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        PrintWriter out = new PrintWriter(socket.getOutputStream());
                ) {
                    String string = in.readLine();

                    JSONObject json = (JSONObject) new JSONParser().parse(string);
                    String type = json.get("type").toString();
                    String task = json.get("task").toString();
                    switch (type) {
                        case "ADD":
                            todos.addTask(task);
                            out.println(todos.getAllTasks());
                            break;
                        case "REMOVE":
                            todos.removeTask(task);
                            out.println(todos.getAllTasks());
                            break;
                        default:
                            out.println("неправильная каманда");
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            System.out.println("Не могу стартовать сервер");
            e.printStackTrace();
        }
    }
}
