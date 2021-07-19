package com.yzc.okhttp3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class TCPTest {

    public static void main(String[] args) {
        try(Socket socket = new Socket("hencoder.com", 80);
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            writer.write("GET / HTTP/1.1\nHost: hencoder.com\n\n");
            writer.flush();
            String message;
            while((message = reader.readLine()) != null){
                System.out.println(message);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
