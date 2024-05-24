package com.dashlexz.spring.rest_clients.rest;


import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import java.util.logging.Logger;

public class RestClient {

    RestTemplate restTemplate = new RestTemplate();
    private static final String URL = "http://94.198.50.185:7081/api/users";
    Logger logger = Logger.getLogger(RestClient.class.getName());

    public static void main(String[] args) {
        RestClient client = new RestClient();
        HttpHeaders sessionHeaders = client.getSessionHeaders();
        client.createUser(sessionHeaders);
        client.updateUser(sessionHeaders);
        client.deleteUser(sessionHeaders);
    }



    public HttpHeaders getSessionHeaders() {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(URL, String.class);
        List<String> cookies = responseEntity.getHeaders().get("Set-Cookie");

        HttpHeaders headers = new HttpHeaders();
        if (cookies != null) {
            headers.set("Cookie", String.join(";", cookies));
        }
        logger.info("Session Headers: " + headers);
        headers.setContentType(MediaType.APPLICATION_JSON);

        return headers;
    }

    public void createUser(HttpHeaders headers) {
        String newUserJson = "{\"id\":3,\"name\":\"James\",\"lastName\":\"Brown\",\"age\":30}";
        HttpEntity<String> requestEntity = new HttpEntity<>(newUserJson, headers);

        ResponseEntity<String> response = restTemplate.exchange(URL, HttpMethod.POST, requestEntity, String.class);
        logger.info("Create User Response: " + response.getBody());
    }

    public void updateUser(HttpHeaders headers) {
        String updatedUserJson = "{\"id\":3,\"name\":\"Thomas\",\"lastName\":\"Shelby\",\"age\":30}";
        HttpEntity<String> requestEntity = new HttpEntity<>(updatedUserJson, headers);

        ResponseEntity<String> response = restTemplate.exchange(URL, HttpMethod.PUT, requestEntity, String.class);
        logger.info("Update User Response: " + response.getBody());
    }

    public void deleteUser(HttpHeaders headers) {
        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(URL + "/3", HttpMethod.DELETE, requestEntity, String.class);
        logger.info("Delete User Response: " + response.getBody());
    }
}



