package com.example.learningmaterials.java.io;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

import okio.Buffer;
import okio.BufferedSource;
import okio.Okio;
import okio.Source;

public class Main {

    public static void main(String[] args) {
//        streamWrite();
//        streamRead();
//        bufferRead();
//        bufferWrite();
//        copyFile();
//        socket();
//        serverSocket();
//        nioBlock();
//        nioNoneBlock();
        okioRead();
    }

    private static void streamWrite(){
        // 自动关闭流
        try(OutputStream out = new FileOutputStream("./build/io_text.txt")) {
            // 二进制写入
            out.write('a');
            out.write('b');
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 不需要
        finally {
//            try{
//                out.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        }
    }

    private static void streamRead(){
        try(InputStream in = new FileInputStream("./build/io_text.txt")) {
            System.out.println((char)in.read());
            System.out.println((char)in.read());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void bufferRead(){
        try(InputStream in = new FileInputStream("./build/io_text.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
//            InputStreamReader reader = new InputStreamReader(in)) {
            System.out.println(br.readLine());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void bufferWrite(){
        try(OutputStream out = new FileOutputStream("./build/io_text.txt");
            BufferedOutputStream br = new BufferedOutputStream(out)) {
            br.write('c');
            br.write('a');
            br.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void copyFile(){
        try(InputStream in = new FileInputStream("./build/io_text.txt");
            OutputStream outputStream = new FileOutputStream("./build/io_new_text.txt")) {
            byte[] data = new byte[1024];
            int read = 0;
            while((read = in.read()) != -1){
                outputStream.write(data, 0, read);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void socket(){
        try(Socket socket = new Socket("hencoder.com", 80);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            bw.write("GET / HTTP/1.1\nHost: www.example.com\n\n");
            bw.flush();

            String message = null;
            while((message = br.readLine()) != null){
                System.out.println(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void serverSocket(){
        try(ServerSocket serverSocket = new ServerSocket(80);
            Socket socket = serverSocket.accept();
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            bw.write("HTTP/1.1 200 OK\n" +
                    "Server: nginx/1.14.0 (Ubuntu)\n" +
                    "Date: Tue, 21 Sep 2021 01:11:08 GMT\n" +
                    "Content-Type: text/html\n" +
                    "Content-Length: 138\n" +
                    "Last-Modified: Fri, 11 Oct 2019 04:19:03 GMT\n" +
                    "Connection: keep-alive\n" +
                    "ETag: \"5da002b7-264\"\n" +
                    "Accept-Ranges: bytes\n" +
                    "\n" +
                    "<html>\n" +
                    "  <head>\n" +
                    "    <title>An Example Page<title>\n" +
                    "  </head>\n" +
                    "  <body>\n" +
                    "    <p>Hello World, this is a very simple HTML document.</p>\n" +
                    "  </body>\n" +
                    "</html>\n\n");
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void nioBlock(){
        try {
            RandomAccessFile file = new RandomAccessFile("./build/io_text.txt", "r");
            FileChannel channel = file.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            channel.read(byteBuffer);
            byteBuffer.flip();

            System.out.println(Charset.defaultCharset().decode(byteBuffer));
            byteBuffer.clear();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void nioNoneBlock(){
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress(80));
            serverSocketChannel.configureBlocking(false);
            Selector selector = Selector.open();
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            while(true){
                selector.select();// 阻塞
                for (SelectionKey selectedKey : selector.selectedKeys()) {
                    if(selectedKey.isAcceptable()){
                        SocketChannel socketChannel = serverSocketChannel.accept();
                        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

                        while(socketChannel.read(byteBuffer) != -1){
                            byteBuffer.flip();
                            socketChannel.write(byteBuffer);
                            byteBuffer.clear();
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void okioRead(){
        try(BufferedSource source = Okio.buffer(Okio.source(new File("./build/io_text.txt")))) {
            // read
//            Buffer buffer = new Buffer();
//            source.read(buffer, 1024);
            System.out.println(source.readUtf8Line());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
