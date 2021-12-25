package com.example.sampleapi.controller;

import com.example.sampleapi.model.SampleData;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleApiController {

    @GetMapping("/getData")
    public ResponseEntity<SampleData> getSampleData(@RequestParam(value = "param",required = false) String parameter){
        if(parameter != null && !parameter.isEmpty()) {
            return ResponseEntity.ok(new SampleData(1,"this is a sample with parameter.",parameter));
        } else {
            return ResponseEntity.ok(new SampleData(1, "This is a just a sample.!"));
        }
    }

}
