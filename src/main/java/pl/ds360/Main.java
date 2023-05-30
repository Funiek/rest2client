package pl.ds360;


import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class Main {
    public static void main(String[] args) {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080/rest1-1.0-SNAPSHOT/sklep/allproducts");
                String message = target.request(MediaType.APPLICATION_JSON).get(String.class);
        System.out.println("response: " + message);


    }
}