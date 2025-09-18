package com.nt.controller;

import com.kwabenaberko.newsapilib.models.response.ArticleResponse;
import com.nt.service.NewsApiService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/news")
@CrossOrigin()
public class NewsApiController {

    @Autowired
    private NewsApiService newsApiService;

    @GetMapping
    public ArticleResponse fetchNews(@RequestParam(defaultValue = "India") String q)
            throws ExecutionException, InterruptedException {
        return newsApiService.getNews(q).get(); // block for result
    }
}
