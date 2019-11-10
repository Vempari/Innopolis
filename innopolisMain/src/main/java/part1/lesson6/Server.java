package part1.lesson6;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;


//GET / HTTP/1.1
//Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8
//Upgrade-Insecure-Requests: 1
//Host: localhost:8000
//User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_1) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/13.0.3 Safari/605.1.15
//Accept-Language: ru
//Accept-Encoding: gzip, deflate
//Connection: keep-alive

public class Server {
    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create((new InetSocketAddress(8000)), 0);
        server.createContext("/", new MyHandler());
        server.setExecutor(null); // creates a default executor
        server.start();
    }

    static class MyHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange t) throws IOException {
            String response = "";
            File file = new File("/Users/vempari/Innopolis/innopolisMain/src/main/java/part1/lesson6");
            File[] list = file.listFiles();
            for (File name : list) {
                response = response + name.toString() + System.lineSeparator();
            }
            t.sendResponseHeaders(200, response.length());
            OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
}
