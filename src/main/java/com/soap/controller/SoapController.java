package com.soap.controller;

import com.soap.client.SoapClient;
import com.soap.wsdl.AddResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class SoapController {

    @Autowired
    private SoapClient soapClient;
    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestParam int numberA, @RequestParam int numberB) {

        Map<String, Integer> reponse = new HashMap<>();
        AddResponse addResponse = soapClient.getAddResponse(numberA,numberB);
        reponse.put("resultado", addResponse.getAddResult());
        return ResponseEntity.ok(reponse);
    }
}
