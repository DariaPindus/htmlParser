package com.rakuten;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.httprpc.RequestMethod;
import org.httprpc.ResourcePath;
import org.httprpc.WebService;

import javax.servlet.annotation.WebServlet;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

@WebServlet(urlPatterns = "/*", loadOnStartup = 1)
public class RequestService extends WebService {

    @RequestMethod("POST")
    @ResourcePath("parse")
    public Item parsePage(String url) {
        System.out.println("Got request " + url);
        try {
            String input = fetchHtml(url);
            return new AmazonItemParser().parse(input);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMethod("GET")
    @ResourcePath("test")
    public String test() {
        return "hello fkkakfa";
    }

    private String fetchHtml(String url) throws IOException {
        System.out.println("[FETCH] " + url);

        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet httpget = new HttpGet(url);
            CloseableHttpResponse response = httpClient.execute(httpget);

            String result = new BufferedReader(new InputStreamReader(response.getEntity().getContent())).lines()
                    .parallel().collect(Collectors.joining("\n"));
            System.out.println("[READ] " + result);
            return result;
        }
    }
}
