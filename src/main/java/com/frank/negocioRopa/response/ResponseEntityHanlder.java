package com.frank.negocioRopa.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResponseEntityHanlder {

    public static ResponseEntity<?> buildResponse(HttpStatus status, Object entity, String message) {
        Map<String, Object> map = new HashMap<>();

        map.put("Status", status);
        map.put("Data", entity);
        map.put("Message", message);

        return new ResponseEntity<Object>(map, status);

    }

    public static ResponseEntity<?> buildResponse(HttpStatus status, List<Object> entity, String message) {
        Map<String, Object> map = new HashMap<>();

        map.put("Status", status);
        map.put("Data", entity);
        map.put("Message", message);

        return new ResponseEntity<Object>(map, status);

    }

    public static ResponseEntity<?> buildResponse(HttpStatus status, String message) {
        Map<String, Object> map = new HashMap<>();

        map.put("Status", status);
        map.put("Data", null);
        map.put("Message", message);

        return new ResponseEntity<Object>(map, status);

    }

}
