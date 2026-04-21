package com.example.demo.controller;

import com.example.demo.model.Url;
import com.example.demo.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UrlController {

    @Autowired
    private UrlService service;

    @PostMapping("/shorten")
    public String shorten(@RequestBody Map<String, String> request) {
        return service.createShortUrl(request.get("url"));
    }

    @GetMapping("/{code}")
    public ResponseEntity<?> redirect(@PathVariable String code) {

        String url = service.getLongUrl(code);

        return ResponseEntity.status(302)
                .location(URI.create(url))
                .build();
    }

    @GetMapping("/analytics/{code}")
    public Url getAnalytics(@PathVariable String code) {
        return service.getUrlDetails(code);
    }
}