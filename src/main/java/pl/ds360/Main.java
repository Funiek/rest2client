package pl.ds360;


import org.eclipse.persistence.jaxb.UnmarshallerProperties;
import pl.ds360.dtos.Product;
import pl.ds360.dtos.ResponseList;
import pl.ds360.dtos.SearchParam;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

public class Main {
    public static void main(String[] args)  {
        System.setProperty("javax.xml.bind.context.factory","org.eclipse.persistence.jaxb.JAXBContextFactory");
        String BASE_URI = "http://localhost:8080/rest1-1.0-SNAPSHOT";
        Client client = ClientBuilder.newClient();
        //allProducts(client);

        WebTarget target = client.target("http://localhost:8080/rest1-1.0-SNAPSHOT/sklep/findProducts");

        SearchParam searchParam = new SearchParam("Pomarancze", 5);
        String message = target.request(MediaType.APPLICATION_JSON).post(Entity.entity(searchParam, MediaType.APPLICATION_JSON), String.class);
        System.out.println("response: " + message);

        try {
            JAXBContext jaxb = JAXBContext.newInstance(ResponseList.class);
            Unmarshaller unmarshaller = jaxb.createUnmarshaller();

            ResponseList responseList = (ResponseList) unmarshaller.unmarshal(new StringReader(message));

            responseList = responseList;
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    private static void allProducts(Client client) {
        WebTarget target = client.target("http://localhost:8080/rest1-1.0-SNAPSHOT/sklep/allproducts");
        String message = target.request(MediaType.APPLICATION_XML).get(String.class);
        System.out.println("response: " + message);
        try {
            JAXBContext jaxb = JAXBContext.newInstance(ResponseList.class);
            Unmarshaller unmarshaller = jaxb.createUnmarshaller();
            //unmarshaller.setProperty(UnmarshallerProperties.MEDIA_TYPE, "application/json");
            //unmarshaller.setProperty(UnmarshallerProperties.JSON_INCLUDE_ROOT, true);

            ResponseList responseList = (ResponseList) unmarshaller.unmarshal(new StringReader(message));

            responseList = responseList;
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
}