package com.example.shrink.controller;

import com.example.shrink.model.ShortenedUrlModel;
import com.example.shrink.repo.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.List;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UrlController {

    @Autowired
    private UrlRepository urlRepository;
    private List<ShortenedUrlModel> shortenedUrlModels;

    @PostMapping(path = "/store", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String storeAndReturnNewId(@RequestBody ShortenedUrlModel requestBody){
        urlRepository.save(requestBody);
        return requestBody.get_id().substring(0, 7);
    }

    @GetMapping(path = "/geturl/{id}")
    public String returnUrlWithSmallId(@PathVariable String id){
        shortenedUrlModels = urlRepository.findAllByShort_id(id);
        String decodedUrl = URLDecoder.decode(shortenedUrlModels.get(0).getUserUrl(), StandardCharsets.UTF_8);
        shortenedUrlModels.clear();
        return decodedUrl;
    }
}
