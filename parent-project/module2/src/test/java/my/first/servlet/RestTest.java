package my.first.servlet;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class RestTest {

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List> products = restTemplate.getForEntity(
                "http://localhost:8080/rest/products",
                List.class);
        System.out.println(products);
    }
}
