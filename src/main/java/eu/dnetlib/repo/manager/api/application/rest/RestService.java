package eu.dnetlib.repo.manager.api.application.rest;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestService {

    private static RestTemplate restTemplate = new org.springframework.web.client.RestTemplate();

    public static String executeGET(String uri){
        return  restTemplate.getForObject(uri,String.class);
    }

    public static String executePOST(String uri,String json){
        return  restTemplate.postForObject(uri,json,String.class);
    }
}
