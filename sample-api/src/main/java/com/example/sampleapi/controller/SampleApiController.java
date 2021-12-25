package com.example.sampleapi.controller;

import com.example.sampleapi.model.Formdata;
import com.example.sampleapi.model.SampleData;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:3000")
public class SampleApiController {

    @GetMapping("/getData")
    public ResponseEntity<SampleData> getSampleData(@RequestParam(value = "param",required = false) String parameter){
        if(parameter != null && !parameter.isEmpty()) {
            return ResponseEntity.ok(new SampleData(1,"this is a sample with parameter.", parameter));
        } else {
            return ResponseEntity.ok(new SampleData(1, "This is a simple sample!"));
        }
    }

    @PostMapping("/create")
    public ResponseEntity<SampleData> postData(@RequestBody Formdata body){
        if(body != null && !body.getVal().isEmpty()) {
            return ResponseEntity.ok(new SampleData(1,"this is a sample with body.", body.getVal()));
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

}
